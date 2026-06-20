console.log("Welcome to the Community Portal");
alert("Page is fully laoded");

const eventName = "Web Development Bootcamp";
const eventDate = "25 June,2026";
let seatCount = 25; 

console.log(`${eventName} is scheduled on ${eventDate}. Available Seats : ${seatCount}`);

console.log("registering new User");
seatCount--;

console.log(`New User registered. Available Seats : ${seatCount}`);


const portalEvents = [
    { title: "Music Festival in the Park", seats: 150, isActive: true },
    { title: "Local Business Networking", seats: 0, isActive: true },
    { title: "Historical Society Seminar", seats: 45, isActive: false }, 
    { title: "AI and Coding Workshop", seats: 30, isActive: true }
];



console.log("--- Scanning Valid Portal Events via forEach() ---");

portalEvents.forEach((item) => {
    if (item.isActive && item.seats > 0) {
        console.log(`[AVAILABLE] ${item.title} - ${item.seats} seats open.`);
    } else {
        console.log(`[HIDDEN/UNAVAILABLE] ${item.title} cannot be displayed.`);
    }
});

function bookTicket(eventItem) {
    try {

        console.log(`Attempting ticket booking for ${eventItem.title}`);

        if (eventItem.seats <= 0) {
            throw new Error("Booking failed, No seat Available");
        }

        seatCount--;
        console.log(`Booked Successfully! Available seats : ${seatCount}`);

    } catch (error) {
        console.error(`[ERROR] ${error.message}`);
    }
}

bookTicket(portalEvents[0]);
bookTicket(portalEvents[1]);

function categoryTracker(categoryName){
    let registrationCount = 0;

    return function () {
        registrationCount++;
        return `Category [${categoryName}] total registration tracked : ${registrationCount}`;
    }
}

const trackMusicRegistration = categoryTracker("Music");
const trackNetworkingRegistration = categoryTracker("Networking");

function filterEvent(eventArray,filterCriteria) {
    const matched = [];

    eventArray.forEach((event) => {
        if (filterCriteria(event)){ 
            matched.push(event);
        }
    });

    return matched;
}

const checkOpenSeats = (evt) => evt.seats > 0;
const checkNetworkTitle = (evt) => evt.title.includes("local");

const AvailableEvents = filterEvent(portalEvents, checkOpenSeats);
console.log(AvailableEvents);

console.log(trackMusicRegistration());
console.log(trackMusicRegistration());
console.log(trackNetworkingRegistration());

//Class creation (Blueprint)
class PortalEvent{
    constructor(title, category, seats) {
        this.title = title;
        this.category = category;
        this.seats = seats;
    }
}
//Prototype
PortalEvent.prototype.checkAvailability = function () {
    return this.seats > 0 ? `${this.seats} remaining seats` : `SOLD OUT`; 
};

//instance of blueprint/class
const seminerEvent = new PortalEvent("CyberSecurity", "Technology", 5);
const theaterEvent = new PortalEvent("Drama Club", "Arts", 0);

console.log(`Title : ${seminerEvent.title}, Category : ${seminerEvent.category}, Seats : ${seminerEvent.seats}`);
console.log(`Title : ${theaterEvent.title}, Category : ${theaterEvent.category}, Seats : ${theaterEvent.seats}`);

console.log(`seminerEvent : ${seminerEvent.checkAvailability()}`);
console.log(`theaterEvent : ${theaterEvent.checkAvailability()}`);

//Object.entries()
const eventMetaData = Object.entries(seminerEvent);

eventMetaData.forEach(([Key, Value]) => {
    console.log(`Key : ${Key} | Value : ${Value}`); 
}); 


const eventRegistry = [
    { title: "Rock the Square", category: "Music", seats: 120 },
    { title: "Baking 101 Masterclass", category: "Workshop", seats: 15 },
    { title: "Jazz under the Stars", category: "Music", seats: 80 }
];


const newEvent = { title: "Robotics and IoT Expo", category: "Technology", seats: 200 };
eventRegistry.push(newEvent);

console.log(eventRegistry.filter(event => event.category === "Music"));

console.log(eventRegistry.map(event => `Event Title : ${event.title}`));



const dynamicContainer = document.querySelector("#dynamicEventContainer");

function renderPortalCards(eventsArray) {

    dynamicContainer.innerHTML = ""; //clearing previous 
    
    eventsArray.forEach((item) => {
        const cardElement = document.createElement("div");
        cardElement.classList.add("eventCard"); //Adds Css using class 

        const titleElement = document.createElement("h3");
        titleElement.innerText = item.title;

        const infoElement = document.createElement("p");
        infoElement.innerText = `Category : ${item.category} | Seats : ${item.seats}`;

        cardElement.appendChild(titleElement);
        cardElement.appendChild(infoElement);

        dynamicContainer.appendChild(cardElement);
    });
}

function fetchEvent() {
    renderPortalCards(eventRegistry);
}

const inputText = document.querySelector("#searchBar"); 

inputText.addEventListener("keydown", function () {

    setTimeout(() => {
        const text = inputText.value.toLowerCase();

        console.log(`Typed String ${text}`);

        const searchResult = eventRegistry.filter(event =>
            event.title.toLowerCase().includes(text)
        );

        renderPortalCards(searchResult);
    }, 10);
}); 

const inputType = document.querySelector("#eventType");

inputType.addEventListener("change", function (event) {
    const categorySelected = event.target.value;

    console.log(`Selected : ${categorySelected}`);

    if (categorySelected === "Select the option") {
        renderPortalCards(eventRegistry);
    } else {
        const filteredList = eventRegistry.filter(event => event.category === categorySelected);
        renderPortalCards(filteredList);
    }
})

const loc = document.querySelector("#geolocation button");
loc.addEventListener("click", function(){
    const display = document.getElementById("locationDisplay");

    if (!navigator.geolocation) {
        display.innerText = "geolocation not supported";
        return;
    }

    display.innerText = "fetching location..."

    const geoOption = {
        enableHighAccuracy: true,
        timeout: 10000
    }

    navigator.geolocation.getCurrentPosition(geoSuccess, geoError, geoOption);

});


function geoSuccess(position) {
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    display = document.getElementById("locationDisplay").innerText = `latitutde : ${lat}°, longitude : ${lon}°`;
}

function geoError(error) {
    const display = document.getElementById("locationDisplay");

    switch (error.code) {
        case error.PERMISSION_DENIED:
            display.innerText = "user denied the permission";
            break;
        case error.POSITION_UNAVAILABLE:
            display.innerText = "location info unavailable";
            break;
        case error.TIMEOUT:
            display.innerText = "time out"
            break;
        default:
            display.innerText = "An unknown error occurs";
            break;
    }
}


function clearPerference() {
    localStorage.clear();
    sessionStorage.clear();
    document.getElementById("eventType").value = "Select the option";
    alert("Preference Cleared");
}

window.onload = () => {
    const savedEvent = localStorage.getItem("preferedEvent");
    if (savedEvent) document.getElementById("eventType").value = savedEvent;
}

window.onbeforeunload = (event) => {
    event.preventDefault();
    return "are sure you wont to leave without completing registration?";
}

function readyToPlay() {
    document.getElementById("videoStatus").innerText = "Your video is ready to play";
}
function zoomImg(img) {
    if (img.style.width == "400px") {
        img.style.width = "200px";
    }
    else img.style.width = "400px";
}

function countChars() {
    var len = document.getElementById("feedback").value.length;
    document.getElementById("count").innerText = len;
}

function checkNum() {
    if (document.getElementById("Phnum").value.length != 10) {
        alert("type valid phone number");
    }
}
function submitForm() {
    document.getElementById("confirmationMessage").innerText = "Registration Successfull!! Thank you";
}

function displayFee() {
    const v = document.getElementById("eventType").value;

    localStorage.setItem("preferedEvent", v);

    if (v == 'Concert') alert("fee : 5000");
    else if (v == 'Workshop') alert("fee : 3000");
    else if (v == 'Town Hall') alert("fee : 4000");
}