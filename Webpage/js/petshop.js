$.get("xml/petsForSale.xml", function(xml) {
    var table = '<table border="1" style="width:100%; text-align:left;">'; // Start the table and add a border for clarity
    table += '<tr><th>Name</th><th>Species</th><th>Breed</th><th>Age</th><th>Color</th><th>Price</th><th>Image</th></tr>'; // Define the header row
    
    $(xml).find('pet').each(function() {
        var name = $(this).find('name').text();
        var species = $(this).find('species').text();
        var breed = $(this).find('breed').text();
        var age = $(this).find('age').text();
        var color = $(this).find('color').text();
        var price = $(this).find('price').text();
        var image = $(this).find('image').text();
        
        // Create a new row for each pet and append data into columns
        table += '<tr>';
        table += '<td>' + name + '</td>';
        table += '<td>' + species + '</td>';
        table += '<td>' + breed + '</td>';
        table += '<td>' + age + '</td>';
        table += '<td>' + color + '</td>';
        table += '<td>' + price + '</td>';
        table += '<td><img src="' + image + '" alt="Image of ' + name + '" style="width:100px;"></td>';
        table += '</tr>';
    });

    table += '</table>'; // Close the table
    $('#petField').html(table); // Insert the table into the designated div
});