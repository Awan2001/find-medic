<?php
require_once('db.php');

 if (!isset($_POST['name']) && !isset($_POST['comments']) ){
   die("Error incomplete HTTP request");



 }

 if (strlen($_POST['name']) < 3  || strlen($_POST['comments'])<5) {

   die("Error plese fill in the form");

 }

//kena filter semua input, bahaya kalau tak filter
$POSTV = filter_input_array(INPUT_POST,
    ['name' => FILTER_SANITIZE_STRING,
     'email' => FILTER_SANITIZE_STRING,
     'comments' => FILTER_SANITIZE_STRING,
     'lat' => FILTER_SANITIZE_STRING,
     'lng' => FILTER_SANITIZE_STRING,
    ]
);
$name = $POSTV['name'];
$email = $POSTV['email'];
$addr = $_SERVER['REMOTE_ADDR'];
$comments = $POSTV['comments'];
$lat = floatval($POSTV['lat']);
$lng = floatval($POSTV['lng']);
$agent = $_SERVER['HTTP_USER_AGENT'];


$query= "INSERT INTO comments (id, name, email, ip_address, user_agent, comments, lat, lng)
VALUES (NULL,'$name','$email','$addr','$agent', '$comments','$lat','$lng')";

$result=mysqli_query($link, $query);

if (!$result) {

  echo mysqli_error($link);

} else {

echo "Comments posted";

}


 ?>
