//Load info on the recordPage
function recordPage(){
    showRecord();
}

//Bring all items in record table in DB
function showRecord() {
    $.ajax({
      url: "http://localhost:8080/api/Record/all",
      type: "GET",
      datatype: "JSON",
      success: function (items) {
        console.log(items);
        paintRecord(items);
      },
    });
  }
  
  //Paint all items in a table in Record page
  function paintRecord(items) {
    let newRow = "<tr>";
    for (let i = 0; i < items.length; i++) {
      newRow += "<td><small>" + items[i].name + "</small></td>";
      newRow += "<td><small>" + items[i].price + "</small></td>";
      newRow += "<td><small>" + items[i].quantity + "</small></td>";
      newRow += "<td><small>" + items[i].description + "</small></td>";
      newRow += "</tr>";
    }
    $("#recordTable").append(newRow);
  }