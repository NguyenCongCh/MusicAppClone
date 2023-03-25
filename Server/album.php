<?php
	require "connect.php";
	$query = "SELECT * FROM Album";
	$data = mysqli_query($con, $query);

	class Album{
		function Album($IdAlbum, $TenAlbum, $TenCaSi, $HinhAnhAlbum){
			$this->IdAlbum = $IdAlbum;
			$this->TenAlbum = $TenAlbum;
			$this->TenCaSi = $TenCaSi;
			$this->HinhAnhAlbum = $HinhAnhAlbum;
		}
	}
	
	$arrayAlbum = array();
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayAlbum, new Album($row['IdAlbum']
												,$row['TenAlbum']
												,$row['TenCaSi']
												,$row['HinhAnhAlbum']));
												 
	}
	
	echo json_encode($arrayAlbum);
?>