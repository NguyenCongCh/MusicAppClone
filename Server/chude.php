<?php
	require "connect.php";
	$query = "SELECT * FROM ChuDe";
	$data = mysqli_query($con, $query);

	class Playlist{
		function Playlist($IdChuDe, $TenChuDe, $HinhChuDe){
			$this->IdChuDe = $IdChuDe;
			$this->TenChuDe = $TenChuDe;
			$this->HinhChuDe = $HinhChuDe;
		}
	}
	
	$arrayChuDe = array();
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayChuDe, new Playlist($row['IdChuDe']
												,$row['TenChuDe']
												,$row['HinhChuDe']));
												 
	}
	
	echo json_encode($arrayChuDe);
?>