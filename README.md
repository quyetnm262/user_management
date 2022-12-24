# User Management - JDBC Servlet
Đây là một project quản lý user với các chức đăng đơn giản: hiển thị danh sách user, thêm user mới, chỉnh sửa thông tin user và tìm kiếm user dựa trên thông tin nhập vào: tên, tuổi, username.

# Mô tả chi tiết
Project sử dụng MySQL bao gồm database có tên là "user_manager", chỉ có một table là "user". Table "user" gồm các cột : id, name, age, sex, address, username,
password. Sử dụng JDBC để giao tiếp với cơ sở dữ liệu. User Management có các chức năng sau:
<ul>

	<li>
		Thêm mới user : Thêm thông tin user bằng cách điền vào các field: name, age, sex, address, username,password và click nút Submit
	</li>

	<li>
		Hiển thị danh sách user: Hiển thị tất cả các thông tin user
	</li>
	<li>
		Chỉnh sửa thông tin user : Chỉnh sửa thông tin user bằng cách click vào nút biểu tượng chỉnh sửa cùng dòng, sau đó sẽ được đưa tới trang có các thông tin của user, chỉnh sửa và lưu bằng cách click vào nút Submit. 
	</li>

	<li>
		Tìm kiếm thông tin user : Điền thông tin muốn tìm kiếm tại trang danh sách user và click nút Tìm kiếm, các field không điền thì sẽ mặc định tìm tất cả, sau đó call api và sẽ hiển thị kết quả lên table.
	</li>
</ul>
Ngoài ra ứng dụng có chức năng login, logout, register và phân quyền người dùng.
<ul>
	<li>
		Login, logout dựa trên session: login thì sẽ khởi tạo một giá trị session và logout sẽ xoá giá trị của session đó.
	</li>
	<li>
		Register: nhập các thông tin và insert vào database, sau đó người dùng có thể đăng nhập vào hệ thống.
	</li>
	<li>
		Phân quyền người dùng: Sử dụng Filter trong Java Servlet. <li>
		<li> 
		Khi người dùng đăng nhập tài khoản với quyền 'user', người dùng sẽ không thể truy cập vào các trang thêm, sửa thông tin người dùng, nếu người dùng 
		cố tình vào thì sẽ bị redirect về trang login. Người dùng chỉ có thể truy cập vào trang hiển thị và sử dụng chức năng tìm kiếm.
		</li>
		<li> 
		Khi người dùng đăng nhập tài khoản với quyền 'admin', người dùng có thể truy cập tất cả các trang.
		</li>
	</li>

</ul>
# Công cụ và Framework
<ul>
<li>
	MySQL
</li>
<li>
	Java Servlet
</li>
<li>
	JSP, JDBC
</li>
<li>
	Jackson Data Binding
</li>

</ul>

# Các bước chạy ứng dụng
<ul>
<li>
Cài đặt MySQL , nếu máy chưa cài thì có thể tải tại: https://www.mysql.com/downloads/

</li>
<li>
	Trong MySQL workbench , chạy query để tạo các cột tại file query.txt và thêm dữ liệu. 
</li>
<li>
	Tại IDE, mở /dao/impl/AbstractDao.java để thay đổi username và password của DataBase phù hợp với cơ sở 
	dữ liệu tại máy của bạn.
	
</li>
<li>
	Chạy với Server TomCat
</li>
<li>

</li>

</ul>