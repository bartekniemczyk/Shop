<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 22.03.2017
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .dropbtn {
            background-color: #000000;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        .dropbtn:hover, .dropbtn:focus {
            background-color: #3e8e41;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            overflow: auto;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown a:hover {
            background-color: #f1f1f1
        }

        .show {
            display: block;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Telefony</title>
</head>
<body>
<section>
    <div class="barto">
        <div class="container">
            <h1>Produkty:</h1>


        </div>
    </div>
</section>


<div class="dropdown">
    <button onclick="myFunction()" class="dropbtn">Kategorie</button>
    <div id="myDropdown" class="dropdown-content">
        <a href="http://localhost:8083/products/Phones">Telefony</a>
        <a href="http://localhost:8083/products/tablet">Tablety</a>
        <a href="http://localhost:8083/products/Laptop">Laptopy</a>
    </div>
</div>
</div>


<div class="dropdown">
    <button onclick="myFunction1()" class="dropbtn">Cena</button>
    <div id="myDropdown1" class="dropdown-content">
        <a href="http://localhost:8083/products/0/450">0-450</a>
        <a href="http://localhost:8083/products/450/900">450-900</a>
        <a href="http://localhost:8083/products/900/1500">900-1500</a>
    </div>
</div>
</div>
<div class="dropdown">
    <button onclick="myFunction2()" class="dropbtn">Producent</button>
    <div id="myDropdown2" class="dropdown-content">
        <a href="http://localhost:8083/products/manufacturer?name=Dell">Dell</a>
        <a href="http://localhost:8083/products/manufacturer?name=Apple">Apple</a>
        <a href="http://localhost:8083/products/manufacturer?name=Google">Google</a>
        <a href="http://localhost:8083/products/manufacturer?name=HTC">HTC</a>
        <a href="http://localhost:8083/products/manufacturer?name=Lenovo">Lenovo</a>
    </div>
</div>
</div>
<div class="row">
    <c:forEach items="${products}" var="product">
        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
            <div class="thumbnail">
                <img src="<c:url value="/resources/images/${product.productId}.jpg"></c:url>"
                     alt="image" style="width:100%"/></div>
                <div class="caption">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>${product.unitPrice}PLN</p>
                    <p>Liczba sztuk w magazynie: ${product.unitsInStock}</p>
                    <p><a href=" <spring:url value="/products/product?id=${product.productId}" />"
                          class="btn btn-primary"> <span class="glyphicon-info-sign glyphicon"/></span> Szczegóły </a>
                    </p>

                </div>
            </div>
        </div>
    </c:forEach>
</div>
</section>
<script>
    /* When the user clicks on the button,
     toggle between hiding and showing the dropdown content */
    function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");

    }
    function myFunction1() {
        document.getElementById("myDropdown1").classList.toggle("show");

    }
    function myFunction2() {
        document.getElementById("myDropdown2").classList.toggle("show");

    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function (event) {
        if (!event.target.matches('.dropbtn')) {

            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }
</script>
</body>
</html>
