create database case_study_furama;
use case_study_furama;

SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
-- table structure for table vi_tri
create table vi_tri(
	id_vi_tri int not null auto_increment primary key,
    ten_vi_tri varchar(45)
);
-- data for table vi_tri
insert into vi_tri(ten_vi_tri) value
	('Tong giam doc'),
    ('Pho tong giam doc'),
    ('Truong bo phan le tan'),
    ('Giam sat bo phan le tan'),
    ('Nhan vien le tan'),
    ('Nhan vien ho tro khach hang'),
    ('Truong bo phan buong phong'),
    ('Nhan vien la, phong'),
    ('Nhan vien dieu phoi'),
    ('Truong bo phan am thuc'),
    ('Nhan vien phuc vu'),
    ('Nhan vien pha che'),
    ('Bep truong dieu hanh'),
    ('Bep pho'),
    ('Nhan vien bep'),
    ('Giam doc kinh doanh tiep thi'),
    ('Nhan vien Marketing'),
    ('Nhan vien kinh doanh'),
    ('Nhan vien PR'),
    ('Ke toan truong'),
    ('Ke toan tong hop'),
    ('Ke toan cong no'),
    ('Nhan vien thu ngan'),
    ('Truong phong nhan su'),
    ('Nhan vien nhan su'),
    ('Thu ky nhan su');
    
-- table structure for table trinh_do
create table trinh_do(
	id_trinh_do int not null auto_increment primary key,
    trinh_do varchar(45)
);
-- data for table trinh_do
insert into trinh_do(trinh_do) value
	('Cao hoc'),
    ('Dai hoc'),
    ('Cao dang'),
    ('THPT');

-- table structure for table bo_phan
create table bo_phan(
	id_bo_phan int not null auto_increment primary key,
	ten_bo_phan varchar(45)
);
-- data for table bo_phan
insert into bo_phan(ten_bo_phan) value
	('Quan ly dieu hanh'),
    ('Le tan'),
    ('Buong phong'),
    ('Am thuc'),
    ('Kinh doanh tiep thi'),
    ('Tai chinh ke toan'),
    ('Hanh chinh nhan su');
    
-- table structure for table nhan_vien
create table nhan_vien(
	id_nhan_vien int not null auto_increment primary key,
    ho_ten varchar(45) not null,
    id_vi_tri int,
    id_trinh_do int,
    id_bo_phan int,
    ngay_sinh date,
    so_cmnd varchar(45),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    constraint fk_vi_tri foreign key(id_vi_tri) references vi_tri(id_vi_tri),
    constraint fk_trinh_do foreign key(id_trinh_do) references trinh_do(id_trinh_do),
    constraint fk_bo_phan foreign key(id_bo_phan) references bo_phan(id_bo_phan)
); 
 
alter table nhan_vien 
	drop foreign key fk_vi_tri,
	add  constraint fk_vitri foreign key(id_vi_tri) references vi_tri(id_vi_tri) on delete cascade,
	drop foreign key fk_trinh_do,
	add  constraint fk_trinhdo_nhanvien foreign key(id_trinh_do) references trinh_do(id_trinh_do) on delete cascade,
	drop foreign key fk_bo_phan,
	add  constraint fk_bophan_nhanvien foreign key(id_bo_phan) references bo_phan(id_bo_phan) on delete cascade;
 
-- data for table nhan_vien
insert into nhan_vien ( ho_ten , ngay_sinh , so_cmnd , luong , sdt , email , dia_chi , id_vi_tri, id_trinh_do , id_bo_phan) value
	('Dang Thi Kim Anh', '1983-02-26','206339509','80.000.000','0335194534','dangthikimanh47@gmail.com','Quang Nam',1,1,1),
    ('Hoang Xuan Anh', '1990-02-22', '194471442', '50.000.000', '0394520208', 'hoangxuananh222@gmail.com', 'Quang Binh',2,1,1),
    ('Nguyen Nho Minh Anh', '1993-09-02', '205948405', '30.000.000', '0764065918', 'salaka.awt@gmail.com','Quang Nam',3,2,2),
    ('Vuong Thi Kim Cuc', '1997-03-09', '197430412', '15.000.000', '0396627644','kimcuc10b1@gmail.com', 'Quang Tri',4,2,2),
    ('Bui Van Thanh Diem', '1996-04-19', '212481532', '8.000.000', '0969141927', 'thanhdiem1904@gmail.com', 'Quang Ngai',5,3,2),
    ('Le Ho Ngoc Dieu', '1996-01-12', '191993993', '8.000.000' , '0969603450','lehongocdieu1996@gmail.com','Da Nang',6,3,2),
    ('Le Duc Anh Dung', '1997-06-22', '194578629','15.000.000', '0965719027','ledung@gmail.com','Quang Binh',7,2,3),
    ('Nguyen Thi Thu Ha', '1997-10-12', '194621635', '8.000.000', '0981282897','nguyenthuha@gmail.com','Quang Binh',8,4,3),
    ('Phan Thi Le Hang', '1996-08-27', '212827397','10.000.000','0967021634','phanthilehang1996@gmail. com','Da Nang',9,3,3),
    ('Nguyen Thi An Hoa', '1997-06-18', '206117711','15.000.000','0356749171','anhoa15697@gmail.com','Binh Phuoc',10,2,4),
    ('Le Thi Dieu Huyen', '1996-09-07','233231932','8.000.000','0375753631','lehuyenx2@gmail.com','Da Nang',11,4,4),
    ('Ha Le Thanh Huyen', '1993-05-02','241797370','8.000.000','0388306302','huyenmup93@gmail.com','Dak Lak',12,4,4),
    ('Ha Manh Hung', '1995-08-20','241496341','20.000.000','0974508315','manhhung10ct@gmail.com','Dak Lak',13,2,4),
    ('Vo Van Hung', '1997-07-27','191897403','12.000.000','0793658056','vovanhung35@gmail.com','Hue',14,4,4),
    ('Nguyen Van Khuong', '1997-03-01','205959015','8.000.000','0772480787','khuong97dx2@gmail.com','Quang Nam',15,4,4),
    ('Huynh Phi Long', '1993-02-13','206007258','15.000.000','0962853800','huynhphilong13021997@gmail.com','Quang Nam',16,2,5),
    ('Truong Vu Thanh Lam', '1989-04-12','212671089','10.000.000','0967 521 607','truongvuthanhlam0204@gmail.com','Quang Ngai',17,2,5),
    ('Ho Thi Nhuoc Nam','1990-03-22','191895504','10.000.000','0395292964','nhuocnam223@gmail.com','Hue',18,2,5),
    ('Ta Thi Huyen Nga','1995-11-03','233231669','10.000.000','0966272397','huyennga03111997@gmail.com','Kon Tum',19,2,5),
    ('Cao Tuan Ngoc', '1990-06-17','191898082','15.000.000','0386537063','caotuanngoc123456789@gmail.com','Hue',20,2,6),
    ('Nguyen Thi Lam Nguyen', '1996-01-05','285661059','10.000.000',' 0345300960','nguyenthilamnguyen0501@gmail.com','Binh Phuoc',21,2,6),
    ('Hoang Thi Thu Nhan', '1993-04-18','233234792','10.000.000','0966269474','thunhan18497@gmail.com','Dak Lak',22,2,6),
    ('Truong Viet Nhan', '1996-04-26','197275982','8.000.000','0962853900','voirung2409@gmail.com','Quang Tri',23,3,6),
    ('Pham Huynh Quang Nhat','1992-01-27','205943256','15.000.000','0977754791','phamhuynhquangnhat@gmail.com','Quang Nam',24,2,7),
    ('Che Ngoc Van Nhi','1993-09-22','191896201','10.000.000','0767142295','vannhiche@gmail.com','Hue',25,2,7),
    ('Phan Thi Thanh Nhung','1997-07-31','206117116','8.000.000','0389582160','phannhung3107@gmail.com','Quang Nam',26,3,7);

select * from nhan_vien;
-- table structure for table loai_dich_vu
create table loai_dich_vu(
	id_loai_dich_vu int not null auto_increment primary key,
    ten_loai_dich_vu varchar(45)
);
-- data for table loai_dich_vu
insert into loai_dich_vu (ten_loai_dich_vu) value
	('Villa'),('House'),('Room');
select * from loai_dich_vu;
-- table structure for table kieu_thue
create table kieu_thue(
	id_kieu_thue int not null auto_increment primary key,
    ten_kieu_thue varchar(45),
    gia int
);
-- data for table kieu_thue
insert into kieu_thue(ten_kieu_thue , gia) value 
	('Thue theo gio', 80000),
    ('Thue theo ngay', 400000),
    ('Thue theo tuan',3000000),
    ('Thue theo thang', 15000000);
select * from kieu_thue;
-- table structure for table dich_vu
create table dich_vu(
	id_dich_vu int not null auto_increment primary key,
    ten_dich_vu varchar(45),
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da int,
    chi_phi_thue int,
    id_kieu_thue int,
    id_loai_dich_vu int,
    trang_thai varchar(45),
    constraint fk_loai_dich_vu foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu),
    constraint fk_kieu_thue foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue)
);
-- data for table dich_vu
insert into dich_vu (id_kieu_thue, id_loai_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, trang_thai) value
	(1,3,'Graden Superior Room',40,0,2,80000,'Con trong'),
    (2,3,'Garden Deluxe King Room',50,0,4,900000,'Con trong'),
    (2,3,'Ocean Deluxe Room',45,0,2,400000,'Het'),
    (2,3,'Family Room',40,0,2,350000,'Con trong'),
    (2,3,'Lagoon Superior',45,0,4,800000,'Con trong'),
    (2,2,'Presidential House',130,2,4,1000000,'Con trong'),
    (3,2,'Ocean House',145,2,4,4000000,'Con trong'),
    (3,2,'Family House',90,1,3,3000000,'Con trong'),
    (3,1,'Pool Villa',320,3,7,6000000,'Con trong'),
    (4,1,'Beach Front Villa',900,3,10,15000000,'Con trong');
select * from dich_vu;
-- table structure for table loai_khach
create table loai_khach(
	id_loai_khach int not null auto_increment primary key,
    ten_loai_khach varchar(45)
);
-- data for table loai_khach
insert into loai_khach( ten_loai_khach ) value
	('Diamond'),('Platinium'),('Gold'),('Silver'),('Member');
select * from loai_khach;
-- table structure for table khach_hang
create table khach_hang(
	id_khach_hang int not null auto_increment primary key,
    id_loai_khach int,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(9),
    sdt varchar(10),
    email varchar(45),
    dia_chi varchar(45),
    constraint fk_loai_khach foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);
-- data for table khach_hang
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt,email,dia_chi) value
	(1,'Vo Thanh Phuc', '1994-8-09','191828743','0333641694','vtphuc89@gmail.com','Da Nang'),
    (1,'Ho Minh Phong', '1996-07-31','201720585','0383010080','hothangphong1@gmail.com','Da Nang'),
    (1,'Le Thi Phuong', '1988-06-02','187637835','0392512253','lephuong266797@gmail.com','Ha Tinh'),
    (2,'Dao Thi Kim Quyen', '1997-10-26', '212485241','0377396129','kimquyentm@gmail.com','Quang Nam'),
    (2,'Phan Thanh Son', '1983-05-04','233268853','0968767152','thanhsonkontum97@gmail.com','KomTum'),
    (2,'Ngo Thi Thu Thao','1997-08-31','233250436','0357128624','thaongo3108@gmail.com','Hue'),
    (3,'Hoang Thi Hong Tham','1996-10-13','194581212','0357081908','hoangtham131096@gmail.com','Quang Tri'),
    (3,'Nguyen Xuan Thang', '1998-08-10','194632983','0865510897','nxt10897@gmail.com','Quang Tri'),
    (3,'Phan Kim Thang','1996-12-04','206177097','0398742019','kimthang.dhsphue03@gmail.com','Quang Nam'),
    (4,'Nguyen Thi Quynh Thoa','1996-02-03','212480283','0976724540','Quynhthoa3296@gmail.com','Quang Tri'),
    (4,'Le Thi Cam Thuy','1979-09-18','241712810','0765451092','lethicamthuy18091997@gmail.com','Dak Lak'),
    (4,'Hoang Thi Nhung Thuy','1997-08-28','205980760','0386308263','htnhungthuy@gmail.com','Quang Nam'),
    (5,'Le Thi Thu','1985-09-03','184142735','0961353295','Dieuhan.tt95@gmail.com','Da Nang'),
    (5,'Phan Thi Cam Tien', '1970-01-29','201724964','0764889005','phanthicamtien12@gmail.com','Da Nang'),
    (5,'Nguyen Thi Bich Tram','1997-11-20','233208486','0976334971','bichtram040596@gmail.com','Hue');
    
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt,email,dia_chi) value
	(3,'Nguyen Thi Bich Tram','1997-12-20','277208486','0976334942','bichtram@gmail.com','Quang Nam'),
	(5,'Hoang Thi Hong Tham','1996-04-01','419581212','0357081980','hoangtham@gmail.com','Quang Binh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt,email,dia_chi) value
	(2,'Nguyen Duc Anh', '1997-09-16','419581213','0121361061','ducanh@gmail.com','Quang Nam');

update khach_hang set dia_chi = 'Quang Ngai' where id_khach_hang = 6 or id_khach_hang = 15;
update khach_hang set dia_chi = 'Vinh' where id_khach_hang = 3;

select * from khach_hang;
-- table structure for table hop_dong
create table hop_dong(
	id_hop_dong int not null auto_increment primary key,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int,
    tong_tien int,
    constraint fk_nhan_vien foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
    constraint fk_khach_hang foreign key(id_khach_hang) references khach_hang(id_khach_hang),
    constraint fk_dich_vu foreign key(id_dich_vu) references dich_vu(id_dich_vu)
);
-- data for table hop_dong
 insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) value
    (6, 3, 6, '2019-09-23', '2019-10-01', 500000),
    (5, 5, 3, '2020-01-23', '2020-01-26', 500000),
    (5, 6, 4, '2020-09-23', '2020-10-05', 500000),
    (4, 1, 4, '2019-12-23', '2019-12-27', 500000),
    (6, 8, 7, '2019-11-23', '2019-11-26', 500000),
    (3, 4, 3, '2020-02-03', '2020-02-10', 500000),
    (4, 3, 1, '2019-06-13', '2019-06-18', 500000),
    (5, 1, 3, '2019-06-12', '2019-06-30', 500000),
    (5, 2, 10, '2019-01-10', '2019-03-10', 500000),
    (5, 3, 4, '2020-03-08', '2020-03-12', 500000);
 insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) value
	(6, 5, 2, '2018-03-01', '2018-03-05', 500000),
    (6, 8, 5, '2018-09-16', '2018-09-22', 500000);
 insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) value
	(5, 6, 4, '2018-02-02', '2018-03-02', 500000);
 insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) value
	(5, 18, 10, '2019-02-02', '2019-05-05', 500000);
 insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) value
	(4, 10, 3, '2015-02-03', '2015-02-10', 500000),
    (4, 11, 5, '2014-03-03', '2014-03-09', 500000);
 insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) value
	(6, 8, 7, '2019-02-23', '2019-11-26', 500000);

update hop_dong
inner join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
inner join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
set tong_tien = dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia;

delete from hop_dong where id_hop_dong > 17;

select * from hop_dong;

-- table structure for table dich_vu_di_kem
create table dich_vu_di_kem(
	id_dich_vu_di_kem int not null auto_increment primary key,
    ten_dich_vu_di_kem varchar(45),
    gia int,
    don_vi int,
    trang_thai_kha_dung varchar(45)
);
-- data for table dich_vu_di_kem
insert into dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung) value
    ('Massage', 300000, 1, 'Con'),
    ('Karaoke', 100000, 1, 'Con'),
    ('An trua', 20000, 1, 'Con'),
    ('An toi', 50000, 1, 'Con'),
    ('An sang', 20000, 1, 'Con'),
    ('Do uong dong chai', 10000, 1, 'Con'),
    ('Xe tham quan', 500000, 1, 'Con');
select * from dich_vu_di_kem;
-- table structure for table hop_dong_chi_tiet
create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int not null auto_increment primary key,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    so_luong int,
    constraint fk_dich_vu_di_kem foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem),
    constraint fk_hop_dong foreign key(id_hop_dong) references hop_dong(id_hop_dong)
);
 -- data for table hop_dong_chi_tiet
insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value
    (2, 2, 1), (3, 2, 2), (3, 2, 1), (5, 3, 1), (3, 2, 1), (4, 4, 1), (1, 6, 1), (2, 1, 1);
insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value
	(6, 3, 2), (7, 5, 2), (8, 2, 1), (9, 3, 1), (10, 4, 1);
insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value
	(11, 3, 1), (12, 4, 3);
insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value
	(13, 4, 2);
insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value
	(14, 4, 3);
insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value
	(15, 4, 3), (16, 5, 2);
insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value
	(17, 3, 3);
    
update hop_dong_chi_tiet set id_dich_vu_di_kem = 4 where ( id_hop_dong_chi_tiet = 4 or id_hop_dong_chi_tiet= 9 or id_hop_dong_chi_tiet= 12 or id_hop_dong_chi_tiet=14);
select * from hop_dong_chi_tiet;