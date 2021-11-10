<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Edit-Delete Booking Office</title>
            <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
            <link rel="stylesheet" href="../../resources/css/header.css">
            <link rel="stylesheet" href="../../resources/css/style-main.css">
            <script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
        </head>

        <body>
            <jsp:include page="../header/header.jsp"></jsp:include>
            <div>
                <jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>

                <form action="#" method="get" class="float-left main-content border-top" id="form-add-employee">
                    <h2 class="m-4">Edit-Delete Booking Office</h2>
                    <hr class="m-4">
                    <table class="m-4">
                        <tr>
                            <td class="font-weight-bold pr-5 pt-2 pb-2">Booking office
                                name <label class="required">(*)</label>
                            </td>
                            <td><input class="box form-control pt-2 pb-2 text-sm"
                                    placeholder="Enter booking office name" type="text" name="bookingOfficeName"
                                    id="bookingOfficeName" required></td>
                        </tr>
                        <tr>
                            <td class="font-weight-bold pr-5 pt-2 pb-2">Trip <label class="required">(*)</label></td>
                            <td><select name="trip" class="box form-control pt-2 pb-2 text-sm">
                                    <option value="gialai" selected>Gia Lai</option>
                                    <option value="khanhhoa">Khanh Hoa</option>
                                    <option value="namdinh">Nam Dinh</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td class="font-weight-bold pr-5 pt-2 pb-2">Phone number <label class="required">(*)</label>
                            </td>
                            <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter phone number"
                                    type="tel" name="phonenumber" id="phonenumber"></td>
                        </tr>
                        <tr>
                            <td class="font-weight-bold pr-5 pt-2 pb-2">Place <label class="required">(*)</label></td>
                            <td><select name="trip" class="box form-control pt-2 pb-2 text-sm">
                                    <option value="quaySo1" selected>Quầy số 1</option>
                                    <option value="quaySo2">Quầy số 2</option>
                                    <option value="quaySo3">Quầy số 3</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td class="font-weight-bold pr-5 pt-2 pb-2">Price <label class="required">(*)</label></td>
                            <td><input name="price" type="number" class="box form-control pt-2 pb-2 text-sm"
                                    id="price">(VNĐ)</td>
                        </tr>
                        <tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Contract deadline
						<label class="required">(*)</label>
					</td>
					<td>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">From
									date</span>
							</div>
							<input name="fromDate" type="date" placeholder="dd/mm/yyyy"
								class="box form-control pt-2 pb-2 text-sm" id="price">
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">To date</span>
							</div>
							<input name="toDate" type="date" placeholder="dd/mm/yyyy"
								class="box form-control pt-2 pb-2 text-sm" id="price">
						</div>
					</td>
				</tr>
                    </table>
                    <div class="d-flex list-btn">
                        <div onclick="clickEdit()" class="btn btn-success mr-1 text-btn">
                            <i class="fas fa-plus mr-1"></i>Update
                        </div>
                        <div onclick="clickDelete()" class="btn btn-danger mr-1 text-btn">
                            <i class="fas fa-trash-alt mr-1"></i>Delete
                        </div>
                    </div>
                </form>
            </div>

            <script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        </body>

        </html>