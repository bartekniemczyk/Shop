<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 06.04.2017
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>

<body>
<section>
    <div class="jumbotron">
        <a href="<c:url value="/logout"/>" class="btn btn-danger btn-mini pull-right"> Wyloguj
            się </a>
        <div class="container"><h1>Produkty</h1>
            <p>Dodaj produkty</p></div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct"
               class="form-horizontal">
        <fieldset>
            <legend>Dodaj nowy produkt</legend>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="productId">
                    <spring:message code="addProduct.form.productId.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="productId" path="productId"
                                type="number" class="form:input-large"/>

                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">
                    <spring:message code="addProduct.form.name.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text"
                                rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="unitPrice">
                    <spring:message code="addProduct.form.price.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice"
                                type="number" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="addProduct.form.description.label"></spring:message>
                </label>
                <div class="col-lg-10">
                    <form:input id="description" path="description"
                                type="text" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="category">
                    <spring:message code="addProduct.form.category.label"></spring:message>
                </label>
                <div class="col-lg-10">
                    <form:input id="category" path="category"
                                type="text" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="manufacturer">
                    <spring:message code="addProduct.form.manufacturer.label"></spring:message>
                </label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer"
                                rows="2"/>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-lg-2" for="unitsInStock">
                    <spring:message code="addProduct.form.unitsinstock.label"></spring:message>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock"
                                type="number" rows="2"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>
