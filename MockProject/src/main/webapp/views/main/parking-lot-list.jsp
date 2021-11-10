<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<div>
<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
<div class="float-left main-content border-top">
            <h2 class="m-4">Parking lot list</h2>
            <hr class="m-4">
            <form id="form-search" class="float-right d-flex mr-4 mb-4">
                <i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
                <input id="input-search" name="input-search" type="text" placeholder="Parking lot Search"
                    class="box-search border-custom p-1 mr-2" style="width: 35%;">
                <i class="fas fa-filter bg-custom border border-icon-search p-2">
                    <p class="d-inline font-weight-normal">Filter by</p>
                </i>
                <select onchange="changeCategory()" name="category" id="category" class="border-custom pt-1 pb-2 mr-2"
                    style="width: 15%;">
                    <option value="place">Place</option>
                    <option value="area">Area</option>
                    <option value="price">Price</option>
                </select>
                <button class="btn btn-info p-1 pl-2 pr-2">Search</button>
            </form>
            <table class="table table-striped ml-4" style="width: 95%;">
                <thead class="font-weight-bold" style="background-color: #e7e7e7;">
                    <tr>
                        <td scope="col">ID</td>
                        <td scope="col">Parking lot</td>
                        <td scope="col">Place</td>
                        <td scope="col">Area</td>
                        <td scope="col">Price</td>
                        <td scope="col">Status</td>
                        <td scope="col">Action</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td scope="col">1</td>
                        <td>Bai so 1</td>
                        <td>Khu Dong</td>
                        <td>20</td>
                        <td>2500000</td>
                        <td>Blank</td>
                        <td class="d-flex"><a href="#" class="mr-2"><i class="fas fa-edit"></i>Edit</a><div onclick="clickDelete(1)" style="cursor: pointer; color: #007bff;"><i class="fas fa-trash mr-1"></i>Delete</div></td>
                    </tr>
                </tbody>
            </table>
            <div class="d-flex ml-4">
                <a href="#" class="p-2 border text-center rounded-left text-black-50"
                    style="width: 6.5%; border-right: 0; overflow: hidden;">Previous</a>
                <a href="#" class="p-2 border pl-3 pr-3 now-index">1</a>
                <a href="#" class="p-2 border text-center rounded-right text-black-50"
                    style="width: 6.5%; border-left: 0;overflow: hidden;">Next</a>
            </div>
        </div>
</div>
</body>
</html>