//Load info on the Index Page
function indexPage() {
  showProducts(); //Charge Products info
  showWishListProducts(); //Charge WishList Products info
}

//Show all products on the index page
function showProducts() {
  $.ajax({
    url: "http://localhost:8080/api/Product/all",
    type: "GET",
    datatype: "JSON",
    success: function (items) {
      console.log(items);
      productsGalery(items);
    },
  });
}

//Paint products on the Index page
function productsGalery(products) {
  let myProducts = '<div class="container"><div class="row">';
  for (let i = 0; i < products.length; i++) {
    myProducts += `
           <div class="card m-2" style="width: 18rem;">
               <div class="card-body">
                   <h5 class="card-title">Nombre: ${products[i].name}</h5>
                   <h6 class="card-subtitle mb-2 text-muted">Precio: $ ${products[i].price}</h6>
                   <h6 class="card-subtitle mb-2 text-muted">Cantidad: ${products[i].quantity}</h6>
                   <p class="card-text">${products[i].description}</p>
                                 
                   <button onclick='addProduct("${products[i].id}", "${products[i].name}", "${products[i].price}", "${products[i].quantity}", "${products[i].description}")'>Agregar a lista de deseos</button>
               </div>
           </div>`;
  }
  myProducts += "</div></div>";
  $("#cardsContainer").append(myProducts);
}

//Create a WishList product an add on the Wish List table
function addProduct(id, name, price, quantity, description) {
  console.log(id);
  let myData = {
    id: id,
    name: name,
    price: price,
    quantity: quantity,
    description: description,
  };
  $.ajax({
    url: "http://localhost:8080/api/WishListProduct/nameExist/" + name +"",
    type: "GET",
    datatype: "JSON",
    success: function (response) {
      console.log(response);
      
      if (response == true) {
        alert("Ya se ha añadido este producto");
      } else {
        let dataToSend = JSON.stringify(myData);
        console.log(myData);
        $.ajax({
          url: "http://localhost:8080/api/WishListProduct/save",
          type: "POST",
          data: dataToSend,
          contentType: "application/json; charset=utf-8",
          datatype: "JSON",
          success: function (item) {
            console.log(item);
            paintItem(item);
            //Saving data in the wish List Record
            let myRecordData = {
              idWLProduct: item.idWLProduct,
              id: item.id,
              name: item.name,
              price: item.price,
              quantity: item.quantity,
              description: item.description,
            };
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
    },
  });
}

//Show all items in Record in a new page
function showRecordPage() {
  window.location.href = "record.html";
  console.log("Entro a showrecordpage");
}

//Show WishList Products on on the Index Page (Wish List table)
function showWishListProducts() {
  $.ajax({
    url: "http://localhost:8080/api/WishListProduct/all",
    type: "GET",
    datatype: "JSON",
    success: function (items) {
      console.log(items);
      paintWishListProducts(items);
    },
  });
}

//Paint all WishList Products on the Index page (Wish List Table)
function paintWishListProducts(items) {
  let newRow = "<tr>";
  for (let i = 0; i < items.length; i++) {
    let idWLProduct = items[i].idWLProduct;
    newRow += "<td><small>" + items[i].name + "</small></td>";
    newRow += "<td><small>" + items[i].price + "</small></td>";
    newRow += "<td><small>" + items[i].quantity + "</small></td>";
    newRow += "<td><small>" + items[i].description + "</small></td>";
    newRow += "<td> <button onclick='bringData(" + idWLProduct + ")'>Actualizar</button>";
    newRow += "<td> <button onclick='deleteData(" + idWLProduct + ")'>Borrar</button>";
    newRow += "</tr>";
  }
  $("#table").append(newRow);
}

//Paint a Product on the Wish List table
function paintItem(item) {
  let newRow = "<tr>";
  let idWLProduct = '"' + item.idWLProduct + '"';
  let id = '"' + item.id + '"';
  newRow += "<td><small>" + item.name + "</small></td>";
  newRow += "<td><small>" + item.price + "</small></td>";
  newRow += "<td><small>" + item.quantity + "</small></td>";
  newRow += "<td><small>" + item.description + "</small></td>";
  newRow += "<td> <button onclick='bringData(" + idWLProduct + ")'>Actualizar</button>";
  newRow += "<td> <button onclick='deleteData(" + idWLProduct + ")'>Borrar</button>";
  newRow += "</tr>";
  $("#table").append(newRow);
  sessionStorage.setItem("id", id);
}

//Bring a WishList Product on a form in order to be updated
function bringData(idWLProduct) {
  console.log(idWLProduct);
  //$("#tableContainer").load("updateProductForm.html");
  window.location.href = "updateProduct.html";
  sessionStorage.setItem("idWLProduct", idWLProduct);
  alert("Modifíque los campos");
}

//DELETE a WhishList Product
function deleteData(idWLProduct) {
  let myData = {
    idWLProduct: idWLProduct,
  };
  //let idWLProduct = idWLProduct;
  let dataToSend = JSON.stringify(myData);
  $.ajax({
    url: "http://localhost:8080/api/WishListProduct/" + idWLProduct + "",
    type: "DELETE",
    data: dataToSend,
    contentType: "application/json; charset=utf-8",
    datatype: "JSON",
    success: function (answer) {
      alert("Se ha borrado con éxito");
      window.location.reload();
    },
  });
}
