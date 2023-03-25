<?php
	$hostname = "localhost";
	$username = "id20432630_tranhieu2911";
	$password = "Android@123btl";
	$databasename = "id20432630_androidmp3";
	
	$con = mysqli_connect($hostname, $username, $password, $databasename);
	if($con)
		echo "";
	else
		echo "That bai";
	
	mysqli_query($con, "SET NAMES 'utf8'");

	
?>