<?php
	require "connect.php";

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

	if(isset($_POST['idBaiHat'])){
		$idBaiHat = $_POST['idBaiHat'];
		$query = "SELECT * FROM baihat WHERE IdBaiHat = '$idBaiHat'";
	}
	
    if(isset($_POST['idAlbum'])){
		$idAlbum = $_POST['idAlbum'];
		$query = "SELECT * FROM baihat WHERE IdAlbum = '$idAlbum'";
	}
	
	if(isset($_POST['idPlaylist'])){
		$idPlaylist = $_POST['idPlaylist'];
		$query = "SELECT * FROM baihat WHERE IdPlaylist = '$idPlaylist'";
	}
	
	if(isset($_POST['idTheLoai'])){
		$idTheLoai = $_POST['idTheLoai'];
		$query = "SELECT * FROM baihat WHERE IdTheLoai = '$idTheLoai'";
	}
	
	$arrayBaiHat= array();
	$data = mysqli_query($con, $query);
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayBaiHat, new BaiHat($row['IdBaiHat']
												,$row['IdAlbum']
												,$row['IdPlaylist']
												,$row['IdTheLoai']
												,$row['TenBaiHat']
												,$row['TenCaSi']
												,$row['HinhAnhBaiHat']
												,$row['LinkBaiHat']));
												 
	}
	
	echo json_encode($arrayBaiHat);
?>