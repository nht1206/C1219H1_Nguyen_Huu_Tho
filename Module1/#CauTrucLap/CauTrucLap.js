function validateMail(mail) {
    let dotPos = mail.indexOf(".");
    let atPos = mail.indexOf("@");
    if ((dotPos === -1 || dotPos === 0) || (atPos === -1 || atPos === 0) || atPos > dotPos) {
        document.getElementById("checkMail").style.display = 'inline';
        return false;
    } else {
        document.getElementById("checkMail").style.display = 'none';
        return true;
    }
}

function validateIDCard(idCard) {
    if (idCard.length !== 9) {
        document.getElementById("checkCard").style.display = 'inline';
        return false;
    }
    for (let i = 0; i < idCard.length; i++) {
        if (parseInt(idCard[i]) <= 0) {
            document.getElementById("checkCard").style.display = 'inline';
            return false;
        } else {
            document.getElementById("checkCard").style.display = 'none';
            return true;
        }
    }
}

function validateBirthday(birth) {
    if (birth === "") {
        document.getElementById("checkBirth").style.display = 'inline';
        return false;
    }
    let idx = birth.indexOf("/");
    let indices = [];
    while (idx != -1) {
        indices.push(idx);
        idx = birth.indexOf("/", idx + 1);
    }
    if (indices.length !== 2) {
        document.getElementById("checkBirth").style.display = 'inline';
        return false;
    }
    if (indices[0] !== 2 && indices[1] !== 5) {
        document.getElementById("checkBirth").style.display = 'inline';
        return false;
    }
    let birthdayArray = birth.split("/");
    let day = parseInt(birthdayArray[0]);
    let month = parseInt(birthdayArray[1]);
    let year = parseInt(birthdayArray[2]);
    if (day <= 0 || day > 30) {
        document.getElementById("checkBirth").style.display = 'inline';
        return false;
    }
    if (month <= 0 || month > 12) {
        document.getElementById("checkBirth").style.display = 'inline';
        return false;
    }
    if (year <= 0 || year > (new Date().getFullYear())){
        document.getElementById("checkBirth").style.display = 'inline';
        return false;
    }
    document.getElementById("checkBirth").style.display = 'none';
    return true;
}


function sendData() {
    let mail = document.getElementById("mail").value;
    let idCard = document.getElementById("idCard").value;
    let discount = document.getElementById("discount").value;
    let quantity = document.getElementById("quantity").value;
    let rentDays = document.getElementById("rentDays").value;
    let birthDay = document.getElementById("birth").value;

    if (isNaN(parseInt(discount)) || parseInt(discount) < 0) {
        document.getElementById("checkDiscount").style.display = 'inline';
        return;
    } else {
        document.getElementById("checkDiscount").style.display = 'none';
    }
    if (isNaN(parseInt(quantity)) || parseInt(quantity) < 0) {
        document.getElementById("checkQuantity").style.display = 'inline';
        return;
    } else {
        document.getElementById("checkQuantity").style.display = 'none';
    }
    if (isNaN(parseInt(rentDays)) || parseInt(rentDays) < 0) {
        document.getElementById("checkDay").style.display = 'inline';
        return;
    } else {
        document.getElementById("checkDay").style.display = 'none';
    }

    if (validateMail(mail) && validateIDCard(idCard) && validateBirthday(birthDay)){
        document.getElementById("display").style.display = "inline";
        document.getElementById("nameDisplay").innerText = document.getElementById("name").value;
        document.getElementById("idDisplay").innerText = document.getElementById("idCard").value;
        document.getElementById("emailDisplay").innerText = document.getElementById("mail").value;
        document.getElementById("addDisplay").innerText = document.getElementById("add").value;
        document.getElementById("birthDisplay").innerText = document.getElementById("birth").value;
        document.getElementById("cusDisplay").innerText = document.getElementById("cus").value;
        document.getElementById("discountDisplay").innerText = document.getElementById("discount").value;
        document.getElementById("quantityDisplay").innerText = document.getElementById("quantity").value;
        document.getElementById("dayDisplay").innerText = document.getElementById("rentDays").value;
        document.getElementById("serviceDisplay").innerText = document.getElementById("service").value;
        document.getElementById("roomDisplay").innerText = document.getElementById("room").value;
        document.getElementById("priceDisplay").innerText = "";
    }

}