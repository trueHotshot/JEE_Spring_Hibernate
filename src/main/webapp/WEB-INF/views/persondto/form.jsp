<%--
  Created by IntelliJ IDEA.
  User: hotshot
  Date: 04.09.18
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>PersonDTO form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<div id="wrapper">

    <div class="container">
        <img class="rounded mx-auto d-block mt-5" src="data:image/png;base64,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">
        <div class="card card-register mx-auto mt-5">
            <div class="card-header">PersonDTO form</div>
            <div class="card-body">
<form:form modelAttribute="personDTO" method="post"  id="contact_form">
    <div class="form-group row">
        <label class="col-md-2 control-label">Login:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:input path="login" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">Password:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:input path="password" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">E-mail:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:input path="email" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">First name:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:input path="firstName" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">Last name:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:input path="lastName" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">Gender:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:radiobuttons items="${genderList}" path="gender" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">Country:</label>
        <div class="col-md-10 inputGroupContainer">
        <form:select path="country" class="form-control">
            <form:option value="-" label="-- Select country --"/>
            <form:options items="${countries}"/>
        </form:select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">Notes:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:textarea path="notes" rows="8" cols="90" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <div class="col-md-2">&nbsp;</div>
        <div class="col-md-10 inputGroupContainer">
            <label><form:checkbox path="mailingList" /> Mailing List Agreement</label>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">Programming skills:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:select path="programmingSkills" items="${skillList}" multiple="true" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-md-2 control-label">Hobbies:</label>
        <div class="col-md-10 inputGroupContainer">
            <form:checkboxes items="${hobbies}" path="hobbies" delimiter="<br>" />
        </div>
    </div>
        <div class="col-md-12">
            <button type="submit" id="submit"  class="btn btn-primary btn-block" >Submit</button>
        </div>
</form:form>
            </div>
        </div>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

</body>
</html>
