<?php
	require "connect.php";
	$query = "SELECT * FROM theloai";
	$data = mysqli_query($con, $query);

	class TheLoai{
		function Playlist($IdTheLoai, $IdChuDe,$TenTheLoai, $HinhTheLoai){
			$this->IdTheLoai = $IdTheLoai;
			$this->IdChuDe = $IdChuDe;
			$this->TenTheLoai = $TenTheLoai;
			$this->HinhTheLoai = $HinhTheLoai;
		}
	}
	
	$arrayTheLoai = array();
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayTheLoai, new TheLoai($row['IdTheLoai']
												,$row['IdChuDe']
												,$row['TenTheLoai']
												,$row['HinhTheLoai']));
												 
	}
	
	echo json_encode($arrayTheLoai);
?>