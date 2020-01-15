class Phone {
    constructor(name) {
        this.name = name;
        this.textMemoryInPreparation = [];
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
        this.textMemoryInPreparation.push(message);
        this.baterry--;
    }
    receiveMessage = (message) => {
        if (!this.isOn()){
            return;
        }
        this.theInbox.push(message);
        this.baterry--;
    }
    sendMessage = (receiver) => {
        if (!this.isOn()){
            return;
        }
        //send the message
        receiver.receiveMessage(this.textMemoryInPreparation[this.textMemoryInPreparation.length - 1]);
        this.textMemoryInPreparation.splice(this.textMemoryInPreparation.length, 1);
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
        return this.sendMessage.join("\n");
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
