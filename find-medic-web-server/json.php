<?php




require_once('db.php');


//select semua row dari table comments
// SQL Query ini boleh ditukar ganti mengikut kesesuaian
// contohnya boleh set LIMIT, WHERE, ORDER, dan GROUP
$query = "SELECT * FROM comments ORDER BY date DESC";
$result=mysqli_query($link,$query);

//declare array
$output = array();

//tambahkan row kepada array untuk setiap baris rekod...
foreach ($result as $row) {
 array_push($output,$row);


}

// assign to json variable
$json=json_encode($output);

//declare document type to json and output json
header("Content-Type: application/json");
echo $json;




?>
