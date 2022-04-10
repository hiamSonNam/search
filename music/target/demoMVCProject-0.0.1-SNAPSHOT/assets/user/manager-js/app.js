const PlAYER_STORAGE_KEY = "MY_PLAYER";
const playButton = document.querySelector(".player-play");
const nextBtn = document.querySelector(".player-next");
const prevBtn = document.querySelector(".player-prev");
const randomBtn = document.querySelector(".player-random");
const repeatBtn = document.querySelector(".player-repeat");
const cdThumb = document.querySelector(".player-image");
const songArtist = document.querySelector(".player-author");
const heading = document.querySelector(".player-title");
const progress = document.querySelector("#progress-bar");
const playlist = document.querySelector("#song-list");
let audio = document.querySelector("#song");
const player = document.querySelector(".player");

const searchBtn = document.querySelector("#searchBtn");
const input = document.querySelector("#inputString").value;

let index = 1;

let suffix = '';
const controller = window.location.href;

function makeAPI(){
	if(controller.includes("artist")) {
		suffix = "nghe-sy=" + controller.split('/')[5];
	} else 
	if(controller.includes("home") || controller.split('/')[4] == ""){
		suffix = "trang-chu";
	} else 
	if(controller.includes("genre")){
		if(controller.split('/')[5] == 1){
			suffix = "trang-chu";
		}else{
			suffix = "the-loai=" + controller.split('/')[5];
		}
	}
}
makeAPI();

let url = 'http://localhost:8080/demoMVCProject/' + suffix;

const myApp = {

    songs: [],
    songsForArtist: [],
    //array of song
    defaultSongs: [],

    currentSong: {},
    listOfSongs: [],

    // cai dat mac dinh
    currentIndex: 0,
    isPlaying: false,
    isRandom: false,
    isRepeat: false,
    config: {},
    config: JSON.parse(localStorage.getItem(PlAYER_STORAGE_KEY)) || {},

    setConfig: function(key, value) {
        this.config[key] = value;
        localStorage.setItem(PlAYER_STORAGE_KEY, JSON.stringify(this.config));
    },

    getSongs: function() {
    	fetch(url)
        	.then(res => res.json())
            .then(api => {
                this.songs = api;
                this.render();
                this.currentSong = this.songs[this.currentIndex];
                this.loadCurrentSong();
            })
    },
    
    //render song
    render: function() {
        const html = this.songs.map((item, index) => {
            return (`
                <div class="song ${index === this.currentIndex ? 'active' : ''}" data-index="${index}">
                <span class="song-index">0${(index++)+1}</span>
                <img
                    src="http://localhost/${item.songThumbnail}"
                    alt=""
                    class="song-image"
                />
                <h4 class="song-title">${item.songName}</h4>
                <h5 class="song-album">${item.artistName}</h5>
                <time class="song-time">${item.songDuration}</time>
                </div>
            `)
        })
        playlist.innerHTML = html.join("");
    },

    //khai bao thuoc tinh
    defineProperties: function() {
        Object.defineProperty(this, "currentSong", {
            get: this.songs[this.currentIndex]
        });
    },

    //ham chuc nang
    handleEvents: function() {
        const _this = this;
        // Handle CD spins / stops
        const cdThumbAnimate = cdThumb.animate([{ transform: "rotate(360deg)" }], {
            duration: 20000,
            iterations: Infinity
        });
        cdThumbAnimate.pause();

        // Handle when click play
        playButton.onclick = function() {
            if (_this.isPlaying) {
                audio.pause();
            } else {
                audio.play();
            }
        };

        // When the song is played
        audio.onplay = function() {
            _this.isPlaying = true;
            player.classList.add("playing");
            playButton.classList.remove("fa-play");
            playButton.classList.add("fa-pause");
            cdThumbAnimate.play();
        };

        // When the song is pause
        audio.onpause = function() {
            _this.isPlaying = false;
            player.classList.remove("playing");
            playButton.classList.add("fa-play");
            playButton.classList.remove("fa-pause");
            cdThumbAnimate.pause();
        };

        // When the song progress changes
        audio.ontimeupdate = function() {
            if (audio.duration) {
                const progressPercent = Math.floor(
                    (audio.currentTime / audio.duration) * 100
                );
                progress.value = progressPercent;
            }
        };

        // Handling when seek
        progress.onchange = function(e) {
            const seekTime = (audio.duration / 100) * e.target.value;
            audio.currentTime = seekTime;
        };

        // When next song
        nextBtn.onclick = function() {
            if (_this.isRandom) {
                _this.playRandomSong();
            } else {
                _this.nextSong();
            }

            audio.play();
            _this.render();
            _this.scrollToActiveSong();
        };

        // When prev song
        prevBtn.onclick = function() {
            if (_this.isRandom) {
                _this.playRandomSong();
            } else {
                _this.prevSong();
            }

            audio.play();
            _this.render();
            _this.scrollToActiveSong();
        };

        // Handling on / off random song
        randomBtn.onclick = function(e) {
            _this.isRandom = !_this.isRandom;
            _this.setConfig("isRandom", _this.isRandom);
            randomBtn.classList.toggle("active", _this.isRandom);
        };

        // Single-parallel repeat processing
        repeatBtn.onclick = function(e) {
            _this.isRepeat = !_this.isRepeat;
            _this.setConfig("isRepeat", _this.isRepeat);
            repeatBtn.classList.toggle("active", _this.isRepeat);
        };

        // Handle next song when audio ended
        audio.onended = function() {
            if (_this.isRepeat) {
                audio.play();
            } else {
                nextBtn.click();
            }
        };

        // Listen to playlist clicks
        playlist.onclick = function(e) {
            const oldNode = document.querySelector(".song.active");
            const newNode = e.target.closest(".song:not(.active)");

            if (newNode) {
                _this.currentIndex = Number(newNode.dataset.index);
                oldNode !== null ? oldNode.classList.remove("active") : "";
                newNode.classList.add("active");
                _this.currentSong = _this.songs[_this.currentIndex];
                _this.loadCurrentSong();
                audio.play();
            }
        };

        //search song
        findBtn.onclick = function() {
            _this.timKiemLoi();
            _this.render(_this.listOfSongs);
            _this.currentSong = _this.listOfSongs[_this.currentIndex];
            
            _this.loadCurrentSong();
        }
    },

    scrollToActiveSong: function() {
        setTimeout(() => {
            document.querySelector(".song.active").scrollIntoView({
                behavior: "smooth",
                block: "nearest"
            });
        }, 300);
    },

    loadCurrentSong: function() {
        heading.textContent = this.currentSong.songName;
        cdThumb.src = "http://localhost/"+this.currentSong.songThumbnail;
        audio.src = "http://localhost/"+this.currentSong.songPath;
        songArtist.textContent = this.currentSong.artistName;
    },

    loadConfig: function() {
        this.isRandom = this.config.isRandom;
        this.isRepeat = this.config.isRepeat;
    },

    nextSong: function() {
        
        this.currentIndex++;
        
        if (this.currentIndex >= this.songs.length) {
            this.currentIndex = 0;
        }
        this.currentSong = this.songs[this.currentIndex];
        this.loadCurrentSong();
    },

    prevSong: function() {
        this.currentIndex--;

        if (this.currentIndex < 0) {
            this.currentIndex = this.songs.length - 1;
        }
        this.currentSong = this.songs[this.currentIndex];
        this.loadCurrentSong();
    },

    playRandomSong: function() {
        let newIndex;
        do {
            newIndex = Math.floor(Math.random() * this.songs.length);
        } while (newIndex === this.currentIndex);

        this.currentIndex = newIndex;
        this.currentSong = this.songs[this.currentIndex];
        this.loadCurrentSong();
    },

    start: function() {
    	
    	this.getSongs();
    	
        this.loadConfig();

        this.currentSong = this.songs[this.currentIndex]

        this.handleEvents();

        this.render();

        randomBtn.classList.toggle("active", this.isRandom);
        repeatBtn.classList.toggle("active", this.isRepeat);
    },
}

myApp.start();