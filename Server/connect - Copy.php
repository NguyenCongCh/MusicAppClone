<?php
	$hostname = "localhost";
	$username = "id20432630_tranhieu2911";
	$password = "i4(k=XA!R^#[@hbE";
	$databasename = "id20432630_androidmp3";
	
	$con = mysqli_connect($hostname, $username, $password, $databasename);
	if($con)
		echo "Thanh Cong";
	else
		echo "That bai";
	


	
?>