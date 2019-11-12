
$(document).ready(function(){
    // Hold a copy of customersData in memory
    const customersData = [];

    /** Adds a new Cuctomer */
    const addCustomer = function(customer) {
        addCustomerToListView(customer);
        addCustomerToArrayData(customer);
        addCustomerToLocalStorage(customer);
    }
    /** Adds the customer data to List UI */
    const addCustomerToListView = function(customer) {
        const newListItem = "<li class='list-group-item'>" + customer.customerId + " | " + customer.fullName + " | " + customer.accType + "</li>";
        $("#ulstCustomersId").append(newListItem);
    }

    /** Adds the customer to the customersData array */
    const addCustomerToArrayData = function(customer) {
        customersData.push(customer);
    }

    /** Adds the customer data to localStorage */
    const addCustomerToLocalStorage = function(customer) {
        let idx = localStorage.length;
        localStorage.setItem(idx, customer.customerId + " | " + customer.fullName + " | " + customer.accType);
    }
    // localStorage.clear(); // if required to crear localStorage
    const localDataSize = localStorage.length;// amount of data in localStorage
    if(localDataSize > 0) {
        // read & display list from localStorage
        for(let i=0; i<localDataSize; i++) {
            const localDataItem = localStorage.getItem(i);
            const customerInfoArray = localDataItem.split("|");
            const customerId = customerInfoArray[0];
            const fullName = customerInfoArray[1];
            const accuType = customerInfoArray[2];
            const objCustomer = {
                "customerId": customerId,
                "fullName": fullName,
                "accType": accuType
            }; 
            addCustomerToListView(objCustomer);
            addCustomerToArrayData(objCustomer);
        }
    } else {
        // Fetch and display CustomerData from Data folder using JQuery AJAX
        $.ajax({
            url: "Data/index.json",
            type: "GET",
            dataType: "json"
        }).done(function(customersData) {
            customersData.forEach((objCustomer) => {
                addCustomer(objCustomer);
            });
        }).fail(function(xhr, status, err) {
            alert("Error: " + status + " - " + err);
        }).always(function(xhr, status) {
            //alert( "The request is complete!" );
        });   
    }
    $("#submit").on("click", function(event) {
        event.preventDefault;
        event.preventDefault();
        const customerId = $("#acc-id").val();
        const fullName = $("#fullName").val();
        const accType = $("#accType").val();
        const objNewCustomer = {
            "customerId": customerId,
            "fullName": fullName,
            "accType": accType
        };
        addCustomer(objNewCustomer);
        $("#acc-id").val("");
        $("#fullName").val("");
        $("#acc-id").focus();
    });
    $("#acc-id").focus();
});
