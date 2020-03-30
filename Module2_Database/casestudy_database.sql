/*2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
 một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự. */
select * from nhan_vien
where ho_ten like "K%" or ho_ten like "H%" or ho_ten like "T%";

/*3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/
select * 
from khach_hang
where (timestampdiff(YEAR, ngay_sinh, curdate()) between 18 and 50) and (dia_chi = "Quang Tri" or dia_chi = "Da Nang");

/*4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
select hop_dong.id_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, count(hop_dong.id_khach_hang) as so_lan_dat_phong
from hop_dong
inner join khach_hang using(id_khach_hang)
inner join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
where loai_khach.ten_loai_khach = "Diamond"
group by hop_dong.id_khach_hang
order by so_lan_dat_phong;

/*5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: 
ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. 
(Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
select khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach,
hop_dong.id_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia) as tong_tien
from khach_hang
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
inner join loai_khach using(id_loai_khach)
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem;

/*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 
(Quý 1 là tháng 1, 2, 3).*/
select id_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from dich_vu
inner join loai_dich_vu using(id_loai_dich_vu)
where id_dich_vu not in
(
	select id_dich_vu 
	from dich_vu
	inner join loai_dich_vu using(id_loai_dich_vu)
	inner join hop_dong using(id_dich_vu)
	where (ngay_lam_hop_dong >= CAST('2019-01-01' AS DATE))
);

/*
7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng 
được Khách hàng đặt phòng  trong năm 2019.
*/
select id_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi, loai_dich_vu.ten_loai_dich_vu
from dich_vu
inner join loai_dich_vu using(id_loai_dich_vu)
inner join hop_dong using(id_dich_vu)
where (year(ngay_lam_hop_dong) = 2018) and 
id_dich_vu not in
(
	select distinct id_dich_vu
	from dich_vu
	inner join loai_dich_vu using(id_loai_dich_vu)
	inner join hop_dong using(id_dich_vu)
	where (year(ngay_lam_hop_dong) = 2019)
);

/*8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang 
không trùng nhau. Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
*/   
select distinct ho_ten from khach_hang;

select ho_ten from khach_hang
group by ho_ten;

select ho_ten from khach_hang
union select ho_ten from khach_hang;

/*
9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng
trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
*/
select month(ngay_lam_hop_dong) as thang, count(id_hop_dong) so_luong_dat_phong
from hop_dong
where year(ngay_lam_hop_dong) = 2019
group by thang
order by thang;

/*
10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).
*/
select id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, count(id_hop_dong_chi_tiet) as so_luong_dvkt
from hop_dong
inner join hop_dong_chi_tiet using(id_hop_dong)
group by id_hop_dong;

/*11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang 
là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
select distinct dich_vu_di_kem, gia, trang_thai_kha_dung
from dich_vu_di_kem
inner join hop_dong_chi_tiet using(id_dich_vu_di_kem)
inner join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
inner join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
inner join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
where (khach_hang.dia_chi = "Vinh" or khach_hang.dia_chi = "Quang Ngai")
		and loai_khach.ten_loai_khach = "Diamond";

/*12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), 
TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/
select hop_dong.id_hop_dong, nhan_vien.ho_ten as ten_nhan_vien, khach_hang.ho_ten, khach_hang.so_dien_thoai,
dich_vu.ten_dich_vu, hop_dong.tien_dat_coc, count(id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem
from hop_dong
inner join nhan_vien using(id_nhan_vien)
inner join khach_hang using(id_khach_hang)
inner join dich_vu using(id_dich_vu)
inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
where ngay_lam_hop_dong between CAST('2019-10-01' AS DATE) and CAST('2019-12-30' AS DATE) and
hop_dong.id_hop_dong not in (
	select hop_dong.id_hop_dong
	from hop_dong
	inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
	where ngay_lam_hop_dong between CAST('2019-01-01' AS DATE) and CAST('2019-06-30' AS DATE)
)
group by id_hop_dong;


/*
13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
*/
select dich_vu_di_kem, count(dich_vu_di_kem) as so_lan_duoc_dat
from dich_vu_di_kem
inner join hop_dong_chi_tiet using(id_dich_vu_di_kem)
inner join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by dich_vu_di_kem
having so_lan_duoc_dat = (
	select count(id_dich_vu_di_kem) as so_lan_duoc_dat 
    from hop_dong_chi_tiet
    group by id_dich_vu_di_kem
    order by count(id_dich_vu_di_kem) desc
    limit 1
);


/*
14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
*/
select dich_vu_di_kem.dich_vu_di_kem, loai_dich_vu.ten_loai_dich_vu, count(dich_vu_di_kem) as so_lan_duoc_dat
from hop_dong
inner join dich_vu using(id_dich_vu)
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
inner join hop_dong_chi_tiet using(id_hop_dong)
inner join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by dich_vu_di_kem.dich_vu_di_kem
having so_lan_duoc_dat = 1;

/*
15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, 
DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
*/
select nhan_vien.id_nhan_vien, ho_ten, trinh_do.trinh_do, bo_phan.ten_bo_phan, so_dien_thoai, 
dia_chi, count(nhan_vien.id_nhan_vien) as so_hop_dong
from nhan_vien
inner join trinh_do using(id_trinh_do) 
inner join bo_phan using(id_bo_phan)
inner join hop_dong using(id_nhan_vien)
where year(ngay_lam_hop_dong) between 2018 and 2019
group by nhan_vien.id_nhan_vien
having so_hop_dong <= 3;

/*
16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
*/
delete from nhan_vien 
where id_nhan_vien not in
(
	select id_nhan_vien
	from hop_dong
	where year(ngay_lam_hop_dong) between 2017 and 2020 
	group by id_nhan_vien
);

/*
17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 
là lớn hơn 10.000.000 VNĐ.
*/
update khach_hang
inner join hop_dong using(id_khach_hang)
set id_loai_khach = 1
where hop_dong.tong_tien >= 10000000;

/*
18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
*/
delete from hop_dong_chi_tiet
where id_hop_dong in (
	select id_hop_dong
	from hop_dong
	where year(ngay_lam_hop_dong) = 2016
);
delete
from hop_dong
where year(ngay_lam_hop_dong) = 2016;

/*
19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
*/
update dich_vu_di_kem
set gia = gia*2
where id_dich_vu_di_kem in (
	select id_dich_vu_di_kem
	from hop_dong_chi_tiet
	group by id_dich_vu_di_kem
	having count(id_dich_vu_di_kem) >= 10
);

/*
20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm 
ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
*/
select id_nhan_vien as ID, ho_ten as ho_ten, ngay_sinh, so_cmnd as cmnd, so_dien_thoai, email, dia_chi
from nhan_vien
union all
select id_khach_hang as ID, ho_ten as ho_ten, ngay_sinh, cmnd, so_dien_thoai, email, dia_chi
from khach_hang;