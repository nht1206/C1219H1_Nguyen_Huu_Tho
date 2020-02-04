class Phone {
    constructor(name) {
        this.name = name;
        this.savedMessage = [];
        this.theInbox = [];
        this.sentMessage = [];
        this.status = false;
        this.baterry = 100;
    }
    isOn = () => this.status;
    start = () => {
        this.status = !this.status;
        if (this.status){
            alert(this.name + " is started!");
        } else {
            alert(this.name + " is off!");
        }
    }
    recharge = () => {
        this.baterry = 100;
        alert(this.name + " is recharged!");
    }
    writeMessage = (message) => {
        if (!this.isOn()){
            return;
        }
        this.savedMessage.push(message);
        this.baterry--;
    }
    receiveMessage = (message) => {
        if (!this.isOn()){
            return;
        }
        this.theInbox.push(message);
        this.baterry--;
    }
    sendMessage = (receiver, message) => {
        if (!this.isOn()){
            return;
        }
        this.sentMessage.push(message);
        //send the message
        receiver.receiveMessage(message);
        this.baterry--;
    }
    getReceivedMessage = () => {
        if (!this.isOn()){
            return;
        }
        this.baterry--;
        return this.theInbox.join("\n");
    }
    getSentMessage = () => {
        if (!this.isOn()){
            return;
        }
        this.baterry--;
        return this.sentMessage.join("\n");
    }
    getSavedMessage = () => {
        if (!this.isOn()){
            return;
        }
        this.baterry--;
        return this.savedMessage.join("\n");
    }
}

let iphone = new Phone("IPhone");
let nokia = new Phone("Nokia");

function start(name) {
    if (name === "Nokia"){
        nokia.start();
    } else {
        iphone.start();
    }
}
function recharge(name) {
    if (name === "Nokia"){
        nokia.recharge();
    } else {
        iphone.recharge();
    }
}
function sendMessage(name) {
    if (name === "Nokia"){
        if (!nokia.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let message = document.getElementById("nokiaScreen").value;
        nokia.sendMessage(iphone, message);
        document.getElementById("nokiaScreen").value = "";
    } else {
        if (!iphone.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let message = document.getElementById("iphoneScreen").value;
        iphone.sendMessage(nokia, message);
        document.getElementById("nokiaScreen").value = "";
    }
}
function readSentMessage(name) {
    if (name === "Nokia"){
        if (!nokia.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let screen = document.getElementById("nokiaScreen");
        screen.value = nokia.getSentMessage();
    } else {
        if (!iphone.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let screen = document.getElementById("iphoneScreen");
        screen.value = iphone.getSentMessage();
    }
}
function readInbox(name) {
    if (name === "Nokia"){
        if (!nokia.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let screen = document.getElementById("nokiaScreen");
        screen.value = nokia.getReceivedMessage();
    } else {
        if (!iphone.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let screen = document.getElementById("iphoneScreen");
        screen.value = iphone.getReceivedMessage();
    }
}

function saveMessage() {
    if (name === "Nokia"){
        if (!nokia.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let screen = document.getElementById("nokiaScreen");
        nokia.writeMessage(screen.value);
        screen.value = "";
    } else {
        if (!iphone.isOn()){
            alert("Turn on your phone.");
            return;
        }
        let screen = document.getElementById("iphoneScreen");
        iphone.writeMessage(screen.value);
        screen.value = "";
    }
}
if (nokia.baterry === 0 || iphone.baterry === 0 ){
    alert("Please charge up your phone.")
}
