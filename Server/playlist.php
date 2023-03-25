<?php
	require "connect.php";
	$query = "SELECT * FROM playlist";
	$data = mysqli_query($con, $query);

	class Playlist{
		function Playlist($IdPlaylist, $Ten, $HinhNen, $HinhIcon){
			$this->IdPlaylist = $IdPlaylist;
			$this->Ten = $Ten;
			$this->HinhNen = $HinhNen;
			$this->HinhIcon = $HinhIcon;
		}
	}
	
	$arrayPlaylist = array();
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayPlaylist, new Playlist($row['IdPlaylist']
												,$row['Ten']
												,$row['HinhNen']
												,$row['HinhIcon']));
												 
	}
	
	echo json_encode($arrayPlaylist);
?>