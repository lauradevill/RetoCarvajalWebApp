function updateFormInfo(){
    let idWLProduct = sessionStorage.getItem("idWLProduct");
    dataCharge(idWLProduct);
    console.log(idWLProduct);
}
//Charge a WishList Product info
function dataCharge(idWLProduct) {
    console.log("entro a Datacharge");
    console.log(idWLProduct);
    $.ajax({
      url: "http://localhost:8080/api/WishListProduct/" + idWLProduct + "",
      type: "GET",
      datatype: "JSON",
      success: function (answer) {
        console.log(answer);
        let item = answer;
        $("#name").val(item.name);
        $("#price").val(item.price);
        $("#quantity").val(item.quantity);
        $("#description").val(item.description);
      },
    });
  }
//Edit a WishList Product information
function editData() {
    let idWLProduct = sessionStorage.getItem("idWLProduct");
    let id = parseInt(sessionStorage.getItem("id"));
    console.log(idWLProduct, id);
    let myData = {
      idWLProduct: idWLProduct,
      id: id,
      name: $("#name").val(),
      price: $("#price").val(),
      quantity: $("#quantity").val(),
      description: $("#description").val(),
    };
    let dataToSend = JSON.stringify(myData);
    console.log(myData);
    $.ajax({
      url: "http://localhost:8080/api/WishListProduct/update",
      type: "PUT",
      data: dataToSend,
      contentType: "application/json; charset=utf-8",
      datatype: "JSON",
      success: function (answer) {
        alert("Se ha actualizado con éxito");

        //Save this update product in Record
        let myRecordData = myData;
        let dataToSend = JSON.stringify(myRecordData);
        console.log(myRecordData);

        $.ajax({
            url: "http://localhost:8080/api/Record/save",
            type: "POST",
            data: dataToSend,
            contentType: "application/json; charset=utf-8",
            datatype: "JSON",
            success: function (item) {
              console.log(item);;
            },
        });
      },
    });
}