let arrNameCustomers = ["Nguyen Thi A", "Le Van Q", "Ho Thi B", "Huynh Van C"];
let numberOfCustomer;
let indexOfCustomer;
let choice = prompt("Select the function\n" +
    "\nAdd new customer(1)" +
    "\nDelete customer(2)"
);

function showCustomers() {
    if (arrNameCustomers.length == 0){
        alert("There is no customer.");
    } else {
        let message = "";
        for (let i = 0; i < arrNameCustomers.length; i++) {
            message += (i + 1) + ": " + arrNameCustomers[i] + "\n";
        }
        alert("List of customer: \n" + message);
    }
}

function addNewCustomer() {
    numberOfCustomer = prompt("Enter the number of customer: ");
    while (numberOfCustomer > 0){
        let nameCustomer = prompt("Enter name of customer: ");
        arrNameCustomers.push(nameCustomer);
        numberOfCustomer--;
    }
    showCustomers();
    arrNameCustomers.sort();
    showCustomers();
}

function deleteCustomer() {
    showCustomers();
    indexOfCustomer = prompt("Enter customer position to delete: ");
    arrNameCustomers.splice(indexOfCustomer - 1, 1);
    showCustomers();
}

switch (choice) {
    case "1" :
        addNewCustomer();
        break;
    case "2" :
        deleteCustomer();
        break;
    default :
        alert("Your option is not found.");
}