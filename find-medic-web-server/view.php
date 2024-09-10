<?php




require_once('db.php');


//select semua row dari table maklumat
// SQL Query ini boleh ditukar ganti mengikut kesesuaian
// contohnya boleh set LIMIT, WHERE, ORDER, dan GROUP
$query = "SELECT * FROM comments ORDER BY date DESC";
$result=mysqli_query($link,$query);
?>
<!doctype html>
<html>
<head><title>View comments</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

  <div class="header">
      <img src="logo.png" alt="Logo"> 
      <h1>Find Medic</h1>
  </div>

  <fieldset>
    <div class="comment">

      <h1>View Comments</h1>
      <ol>
        <?php foreach ($result as $row) {

      ?>
      <li>
          <ul>
            <li><small>Date: <?=$row['date']?></small></li>
            <li><small>CommentID: <?=$row['id']?></small></li>
            <li><small>User Location: <?=$row['lat']?>, <?=$row['lng']?></small></li>
            <li><small>User Agent: <?=$row['user_agent']?></small></li>
            <li><a href="mailto:<?=$row['email']?>"">
              <?=$row['name']?></a> wrote.. <br />
            <blockquote><em><?=$row['comments']?></em></blockquote></li>

          </ul><br />

      </li>



      <?php } ?>

      </ol>
    </div>
  </fieldset>

</body>
</html>
