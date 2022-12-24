<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/08/22
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>AdminLTE 3 | Starter</title>

    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="template/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="template/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">

            <li class="nav-item">
                <a class="nav-link" data-slide="true" href="${pageContext.request.contextPath}/logout" role="button"><i class="fa-solid fa-right-from-bracket"></i>Đăng xuất</a>

            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="${pageContext.request.contextPath}/admin-home" class="brand-link">
            <img src="template/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar userDto panel (optional) -->
            <div class="userDto-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="template/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">

                    <a href="#" class="d-block">${sessionScope.USER.username }</a>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/admin-user?type=" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>Quản lý người dùng</p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">Quản lý người dùng</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin-home">Home</a></li>
                            <li class="breadcrumb-item active">Quản lý người dùng</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Thông tin người dùng</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form role="form" action="${pageContext.request.contextPath}/admin-user" method="post" id="quickForm">
                                <input name="id" value="${userEdit.id}" hidden="true">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="name">Tên đầy đủ</label>
                                        <input  name="name" value="${userEdit.name}" class="form-control" id="name" placeholder="Nhập tên">
                                    </div>
                                    <div class="form-group">
                                        <label for="address">Địa chỉ</label>
                                        <input name="address" value="${userEdit.address}" class="form-control" id="address" placeholder="Nhập địa chỉ">
                                    </div>
                                    <div class="form-group">
                                        <label for="username">Tên đăng nhập</label>
                                        <c:if test="${userEdit != null}">
                                            <input readonly name="username" value="${userEdit.username}" class="form-control" id="username" placeholder="Nhập tên tài khoản">
                                        </c:if>
                                        <c:if test="${userEdit == null}">
                                            <input name="username" class="form-control" id="username" placeholder="Nhập tên tài khoản">
                                        </c:if>
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Mật khẩu</label>
                                        <c:if test="${userEdit != null}">
                                            <input readonly name="password" value="${userEdit.password}" type="password" class="form-control" id="password" placeholder="Nhập mật khẩu">
                                        </c:if>
                                        <c:if test="${userEdit == null}">
                                            <input name="password" type="password" class="form-control" id="password" placeholder="Nhập mật khẩu">
                                        </c:if>
                                    </div>
                                    <div class="form-group">
                                        <label for="age">Tuổi</label>
                                        <input  name="age" value="${userEdit.age}" class="form-control" id="age" placeholder="Nhập tuổi">
                                    </div>
                                    <div class="form-group">
                                        <label for="sex">Giới tính</label>
                                        <input name="sex"
                                            <c:if test="${userEdit.sex == 1}">
                                                value="Nam"
                                            </c:if>
                                            <c:if test="${userEdit.sex == 2}">
                                                   value="Nữ"
                                            </c:if>
                                               class="form-control" id="sex" placeholder="Nhập giới tính">

                                    </div>

                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!--/.col (left) -->
                    <!-- right column -->
                    <div class="col-md-6">

                    </div>
                    <!--/.col (right) -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
        <div class="p-3">
            <h5>Title</h5>
            <p>Sidebar content</p>
        </div>
    </aside>
    <!-- /.control-sidebar -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="float-right d-none d-sm-inline">
            Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2014-2019 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="template/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="template/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="template/dist/js/adminlte.min.js"></script>
<script src="https://kit.fontawesome.com/cd553914f6.js" crossorigin="anonymous"></script>

</body>
</html>
