<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="tr">
  
  <head>
    <meta charset="utf-8">
    <style type="text/css">
    .btn-lg {
        padding: 10px 16px;
	    font-size: 18px;
	    line-height: 1.3333333;
	    border-radius: 6px;
    }
    </style>
    <title>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style>
      body { padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */ }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
      </script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <style>
    </style>
  </head>
  <body style="background-image: url(assets/img/bg.gif)">
    <div class="navbar navbar-fixed-top navbar-inverse">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand">
            Borcelik | HRC KDS Uygulamasi
          </a>
          <ul class="nav">
          </ul>
        </div>
      </div>
    </div>
    <div class="container">
        <!-- <div class="hero-unit">
        <div>
          <h1>
            HRC-KDS
          </h1>
          <p>

          </p>
        </div>
        <a class="btn btn-primary" href="cplGecmis.html">
          CplGecmis »
        </a>
      </div>-->
      <div>
      	<div class="row">
      		<div class="col-xs-12">
      			<button class="btn-lg btn-primary btn-block">MRPKDS Rezervasyonsuz Güncelle</button>
      		</div>
      	</div>
      	<div class="row">
      		<div class="col-xs-12">
      			<button class="btn-lg btn-danger btn-block" onclick="document.location.href='cplGecmis.html'">CPL/RCM Güncelle</button>
      		</div>
      	</div>
      	<div class="row">
      		<div class="col-xs-12">
      			<button class="btn-lg btn-info btn-block">Tedarikçi Verisi Güncelle</button>
      		</div>
      	</div>
      	<div class="row">
      		<div class="col-xs-12">
      			<button class="btn-lg btn-warning btn-block">Hat Vardiya Doluluk Güncelle</button>
      		</div>
      	</div>
      </div>
      <div>
      </div>
    </div>
    
    <script src="jquery-1.8.3.js">
    </script>
    
    <script src="assets/js/bootstrap.js">
    </script>
  </body>
</html>