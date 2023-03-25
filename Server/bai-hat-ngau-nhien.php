<?php
	require "connect.php";
	$query = "SELECT * FROM baihat LIMIT 3";
	$data = mysqli_query($con, $query);

	class BaiHat{
		function BaiHat($IdBaiHat, $IdAlbum, $IdTheLoai, $IdPlayList ,$TenBaiHat, $HinhBaiHat,$CaSi, $LinkBaiHat){
			$this->IdBaiHat = $IdBaiHat;
			$this->IdAlbum = $IdAlbum;
			$this->IdPlayList = $IdPlayList;
			$this->IdTheLoai = $IdTheLoai;
			$this->TenBaiHat = $TenBaiHat;
			$this->CaSi = $CaSi;
			$this->HinhBaiHat = $HinhBaiHat;
			$this->LinkBaiHat = $LinkBaiHat;
		}
	}
	
	$arrayBaiHat= array();
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayBaiHat, new BaiHat($row['IdBaiHat']
												,$row['IdAlbum']
												,$row['IdTheLoai']
												,$row['IdPlayList']
												
												,$row['TenBaiHat']
												,$row['HinhBaiHat']
												,$row['CaSi']
												
												,$row['LinkBaiHat']));
												 
	}
	
	echo json_encode($arrayBaiHat);
?>