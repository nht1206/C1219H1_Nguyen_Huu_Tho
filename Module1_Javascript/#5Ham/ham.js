let choice;
let arrListCustomers = [];

let displayMainMenu = function () {
    choice = prompt("Choose an action\n" +
        "(1) Add new customer. \n" +
        "(2) Display Information Customer. \n" +
        "(3) Edit Information Customer. \n" +
        "(4) Delete Customer. \n" +
        "(5) Exit.\n"
    );
    switch (choice) {
        case "1":
            addNewCustomer();
            break;
        case "2":
            displayCustomers();
            break;
        case "3":
            editCustomer();
            break;
        case "4":
            deleteCustomer();
            break;
        default:
            break;
    }
}
let enterNewCustomer = function() {
    let nameCustomer = prompt("Nhập tên người dùng: ");
    let idCard = prompt("Nhập CMND khách hàng: ");
    let birthdayCustomer = prompt("Nhập ngày sinh khách hàng");
    let emailCustomer = prompt("Nhập email khách hàng: ");
    let addressCustomer = prompt("Nhập địa chỉ khách hàng: ");
    let typeCustomer = prompt("Nhập loại khách hàng: ");
    let discount = parseFloat(prompt("Nhập giảm giá: "));
    let numberOfAccompanying = prompt("Nhập số lượng đi kèm: ");
    let typeRoom = prompt("Nhập loại phòng: ");
    let rentDays = parseInt(prompt("Nhập số ngày thuê: "));
    let typeService = prompt("Nhập loại phục vụ: ");
    let customer = {
        nameCustomer: nameCustomer,
        idCard: idCard,
        birthdayCustomer: birthdayCustomer,
        emailCustomer: emailCustomer,
        addressCustomer: addressCustomer,
        typeCustomer: typeCustomer,
        discount: discount,
        numberOfAccompanying: numberOfAccompanying,
        typeRoom: typeRoom,
        rentDays: rentDays,
        typeService: typeService
    }
    return customer;
}
let addNewCustomer = function () {
    let customer = enterNewCustomer();
    arrListCustomers.push(customer);
    displayMainMenu();
}
let displayInformationCustomer = function (customer) {
    alert("Thông tin khách hàng : \n" +
        "Tên khách hàng: " + customer.nameCustomer +
        "\nId card: " + customer.idCard +
        "\nNgày sinh: " + customer.birthdayCustomer +
        "\nEmail: " + customer.emailCustomer +
        "\nĐịa chỉ: " + customer.addressCustomer +
        "\nLoại khách hàng: " + customer.typeCustomer +
        "\nSố lượng đi kèm: " + customer.numberOfAccompanying +
        "\nLoại phòng: " + customer.typeRoom +
        "\nLoại phục vụ: " + customer.typeService
    );
    displayCustomers();
}
let getListCustomer = function() {
    let result = "";
    for (let i = 0; i < arrListCustomers.length; i++) {
        result += i + ": " + arrListCustomers[i].nameCustomer + ": " + arrListCustomers[i].idCard + "\n";
    }
    return result;
}
let displayCustomers = function () {
    let result = getListCustomer();
    result += arrListCustomers.length + ": " + "Back"
    let choice = prompt(result);
    if (choice === arrListCustomers.length.toString() || parseInt(choice) > arrListCustomers.length || parseInt(choice) < 0) {
        displayMainMenu();
        return;
    }
    displayInformationCustomer(arrListCustomers[choice]);
}
let editCustomer = function(){
    let result = getListCustomer();
    let choice = prompt(result);
    if (parseInt(choice) >= arrListCustomers.length || parseInt(choice) < 0) {
        displayMainMenu();
        return;
    }
    let customer = enterNewCustomer();
    let confirm = prompt("Are you sure to save this.\n" +
        "(1) Yes\n" +
        "(0) No"
    );
    if (confirm === "1" ){
        arrListCustomers[choice] = customer;
    } else {
        displayMainMenu();
    }
    displayInformationCustomer(arrListCustomers[choice]);
}
let deleteCustomer = function () {
    let result = getListCustomer();
    let choice = prompt(result);
    if (parseInt(choice) >= arrListCustomers.length || parseInt(choice) < 0) {
        displayMainMenu();
        return;
    }
    arrListCustomers.splice(choice, 1);
    displayCustomers();
}
displayMainMenu();
