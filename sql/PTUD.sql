create database QLKaraoke20
go
use QLKaraoke20
GO
CREATE TABLE KhachHang(
	MaKhachHang NVARCHAR(100) PRIMARY KEY,
	TenKhachHang NVARCHAR(100) NOT NULL,
	SoDienThoai NVARCHAR (100) NOT NULL,
	DiaChi NVARCHAR(100) NOT NULL,
	TongTienHoaDon int NOT NULL
)

CREATE TABLE NhaCungCap(
	MaNhaCungCap NVARCHAR(100) PRIMARY KEY,
	TenNhaCungCap NVARCHAR(100) NOT NULL,
	DiaChi NVARCHAR(100) NOT NULL,
	SoDienThoai	NVARCHAR(100) NOT NULL,
)

CREATE TABLE LoaiDichVu(
	MaLoaiDichVu NVARCHAR(100) PRIMARY KEY,
	TenLoaiDichVu NVARCHAR(100) NOT NULL,
	MoTa NVARCHAR(100) NOT NULL
	
)

CREATE TABLE ChucVu(
	MaChucVu NVARCHAR(100) PRIMARY KEY,
	TenChucVu NVARCHAR(100) NOT NULL,
	MoTa NVARCHAR(100) NOT NULL,
	
)


CREATE TABLE NhanVien(
	MaNhanVien NVARCHAR(100) PRIMARY KEY,
	TenNhanVien NVARCHAR(100) NOT NULL,
	DiaChi NVARCHAR(100) NOT NULL,
	SoDienThoai NVARCHAR(100) NOT NULL,
	SoHoaDonLap int NOT NULL,
	TongTienHoaDon int NOT NULL,
	MaChucVu NVARCHAR(100) NOT NULL,
	FOREIGN KEY(MaChucVu) REFERENCES dbo.ChucVu(MaChucVu),
)


CREATE TABLE LoaiPhong(
	MaLoaiPhong NVARCHAR(100) PRIMARY KEY,
	TenLoaiPhong NVARCHAR(100) NOT NULL,
	MoTa NVARCHAR(100) NOT NULL,
	
)
CREATE TABLE Phong(
	MaPhong NVARCHAR(100) PRIMARY KEY,
	TenPhong NVARCHAR(100) NOT NULL,
	MaLoaiPhong NVARCHAR(100)NOT NULL,
	GiaLoaiPhong NVARCHAR(100) NOT NULL,
	FOREIGN KEY(MaLoaiPhong) REFERENCES dbo.LoaiPhong(MaLoaiPhong),
)

CREATE TABLE DichVu(
	MaDichVu NVARCHAR(100) PRIMARY KEY,
	TenDichVu NVARCHAR(100) NOT NULL,
	MoTa NVARCHAR(100) NOT NULL,
	MaLoaiDichVu NVARCHAR(100) NOT NULL,
	MaNhaCungCap NVARCHAR(100) NOT NULL,
	SoLuongTon int NOT NULL,
	Gia int NOT NULL,
	AnhDichVu Nvarchar (100) not null
	FOREIGN KEY(MaLoaiDichVu) REFERENCES dbo.LoaiDichVu(MaLoaiDichVu),
	FOREIGN KEY(MaNhaCungCap) REFERENCES dbo.NhaCungCap(MaNhaCungCap),
	
)
CREATE TABLE HoaDon(
	MaHoaDon NVARCHAR(100) PRIMARY KEY,
	Ngay NVARCHAR(100) NOT NULL,
	MaKhachHang NVARCHAR(100) NOT NULL,
	MaNhanVien NVARCHAR(100) NOT NULL,
	MaPhong NVARCHAR(100) NOT NULL,
	TongTien NVARCHAR (100) NOT NULL,
	TienKhachDua NVARCHAR (100) NOT NULL,
	FOREIGN KEY(MaNhanVien) REFERENCES dbo.NhanVien(MaNhanVien),
	FOREIGN KEY(MaKhachHang) REFERENCES dbo.KhachHang(MaKhachHang),
	FOREIGN KEY(MaPhong) REFERENCES dbo.Phong(MaPhong),
)

CREATE TABLE ChiTietHoaDon(
	MaCTHoaDon NVARCHAR(100) PRIMARY KEY,
	MaDichVu NVARCHAR(100) NOT NULL,
	SoLuong int NOT NULL,
	MaHoaDon NVARCHAR(100) NOT NULL,
	ThanhTien NVARCHAR (100) NOT NULL,
	FOREIGN KEY(MaDichVu) REFERENCES dbo.DichVu(MaDichVu),
	FOREIGN KEY(MaHoaDon) REFERENCES dbo.HoaDon(MaHoaDon),
)

CREATE TABLE PhieuDatPhong(
	MaPhieuDatPhong NVARCHAR(100) PRIMARY KEY,
	MaPhong NVARCHAR(100) NOT NULL,
	MaKhachHang NVARCHAR(100) NOT NULL,
	NgayDat NVARCHAR(100) NOT NULL,
	FOREIGN KEY(MaPhong) REFERENCES dbo.Phong(MaPhong),
	FOREIGN KEY(MaKhachHang) REFERENCES dbo.KhachHang(MaKhachHang),
)

CREATE TABLE PhieuNhapHang (
	MaPhieuNhapHang NVARCHAR (100) PRIMARY KEY,
	ThoiGian NVARCHAR (100) NOT NULL,
	SoLuong int NOT NULL,
	TongTien NVARCHAR(100) NOT NULL,
	MaNhaCungCap NVARCHAR(100) NOT NULL,
	FOREIGN KEY (MaNhaCungCap) REFERENCES dbo.NhaCungCap (MaNhaCungCap),
)


INSERT LoaiDichVu VALUES ('LDV_001',N'Karaoke','')
INSERT LoaiDichVu VALUES ('LDV_002',N'Nước Ngọt','')
INSERT LoaiDichVu VALUES ('LDV_003',N'Trái Cây','')
INSERT LoaiDichVu VALUES ('LDV_004',N'Đồ Ăn','')
INSERT LoaiDichVu VALUES ('LDV_005',N'Khăn Ướt','')
INSERT LoaiDichVu VALUES ('LDV_006',N'Thuốc Lá','')
INSERT LoaiDichVu VALUES ('LDV_007',N'Bia','')

INSERT NhaCungCap VALUES ('NCC_001',N'Minh Long',N'TP.HCM','0909090988')
INSERT NhaCungCap VALUES ('NCC_002',N'Phát Đạt',N'Đà Nẵng','0905696578')
INSERT NhaCungCap VALUES ('NCC_003',N'VinaCook',N'Bà Rịa','0368465465')
INSERT NhaCungCap VALUES ('NCC_004',N'Hồ Tiến',N'Hà Nội','0321104655')
INSERT NhaCungCap VALUES ('NCC_005',N'Tấn Phát',N'TP.HCM','0851326846')
INSERT NhaCungCap VALUES ('NCC_006',N'Phúc Lộc Thọ',N'Đà Nẵng','0905696578')

INSERT DichVu VALUES ('DV_001',N'Giờ Hát ( VIP )','','LDV_001','NCC_001',0,250000,'hinh/service/micro.png')
INSERT DichVu VALUES ('DV_002',N'Giờ Hát ( Thường )','','LDV_001','NCC_001',0,180000,'hinh/service/micro.png')
INSERT DichVu VALUES ('DV_003',N'Trà Olong','','LDV_001','NCC_001',40,50000,'hinh/service/traolong.png')
INSERT DichVu VALUES ('DV_004',N'Sting','','LDV_001','NCC_001',40,50000,'hinh/service/sting.png')
INSERT DichVu VALUES ('DV_005',N'7 Up ','','LDV_001','NCC_001',40,50000,'hinh/service/7 up.png')
INSERT DichVu VALUES ('DV_006',N'Nước cam','','LDV_001', 'NCC_001',40,50000,'hinh/service/nuoccam.png')
INSERT DichVu VALUES ('DV_007',N'Bia Tiger','','LDV_001', 'NCC_001',40,50000,'hinh/service/Tiger.png')
INSERT DichVu VALUES ('DV_008',N'Bia SaiGon','','LDV_001', 'NCC_002',40,50000,'hinh/service/saigonxanh.png')
INSERT DichVu VALUES ('DV_009',N'Bia 333','','LDV_001', 'NCC_002',40,50000,'hinh/service/333.png')
INSERT DichVu VALUES ('DV_010',N'Chivas','','LDV_001', 'NCC_002',40,50000,'hinh/service/Chivas.png')
INSERT DichVu VALUES ('DV_011',N'Korbell','','LDV_001', 'NCC_002',40,50000,'hinh/service/Korbell.png')
INSERT DichVu VALUES ('DV_012',N'Redlabel','','LDV_001', 'NCC_002',40,50000,'hinh/service/Redlabel.png')
INSERT DichVu VALUES ('DV_013',N'Nước lavie','','LDV_001', 'NCC_003',40,50000,'hinh/service/nuocloc.png')
INSERT DichVu VALUES ('DV_014',N'Trái cây','','LDV_001', 'NCC_003',40,50000,'hinh/service/traicay.png')
INSERT DichVu VALUES ('DV_015',N'Cơm chiên','','LDV_001', 'NCC_003',40,50000,'hinh/service/comchien.png')
INSERT DichVu VALUES ('DV_016',N'Mì xào','','LDV_001', 'NCC_003',40,50000,'hinh/service/mixao.png')
INSERT DichVu VALUES ('DV_017',N'Tôm chiên','','LDV_001', 'NCC_003',40,50000,'hinh/service/tomchien.png')
INSERT DichVu VALUES ('DV_018',N'Đồ chiên','','LDV_001', 'NCC_003',40,50000,'hinh/service/dochien.png')
INSERT DichVu VALUES ('DV_019',N'Mực nướng','','LDV_001', 'NCC_003',40,50000,'hinh/service/muc.png')
INSERT DichVu VALUES ('DV_020',N'Bắp bê','','LDV_001', 'NCC_003',40,50000,'hinh/service/bapbe.png')
INSERT DichVu VALUES ('DV_021',N'Kem vani','','LDV_001', 'NCC_003',40,50000,'hinh/service/kemvani.png')
INSERT DichVu VALUES ('DV_022',N'Kem socola','','LDV_001', 'NCC_004',40,50000,'hinh/service/kemsocola.png')
INSERT DichVu VALUES ('DV_023',N'Kem dâu','','LDV_001', 'NCC_004',40,50000,'hinh/service/kemdau.png')
INSERT DichVu VALUES ('DV_024',N'Thuốc Jet','','LDV_001', 'NCC_004',40,50000,'hinh/service/jet.png')
INSERT DichVu VALUES ('DV_025',N'Thuốc Mèo','','LDV_001', 'NCC_004',40,50000,'hinh/service/meo.png')
INSERT DichVu VALUES ('DV_026',N'Thuốc 555','','LDV_001', 'NCC_004',40,50000,'hinh/service/555.png')
INSERT DichVu VALUES ('DV_027',N'Khăn ướt','','LDV_001', 'NCC_004',40,50000,'hinh/service/khan.png')
INSERT DichVu VALUES ('DV_028',N'Đậu phộng','','LDV_001', 'NCC_004',40,50000,'hinh/service/dauphong.png')
INSERT DichVu VALUES ('DV_029',N'Mực bento','','LDV_001', 'NCC_004',40,50000,'hinh/service/mucbento.png')
INSERT DichVu VALUES ('DV_030',N'Bánh orion','','LDV_001', 'NCC_004',40,50000,'hinh/service/orion.png')
INSERT DichVu VALUES ('DV_031',N'Kẹo sigum','','LDV_001', 'NCC_001',40,50000,'hinh/service/sigum.png')
INSERT DichVu VALUES ('DV_032',N'Snack khoai tây','','LDV_001', 'NCC_001',40,50000,'hinh/service/snackkhoaitay.png')
INSERT DichVu VALUES ('DV_033',N'Snack rongbien','','LDV_001', 'NCC_001',40,50000,'hinh/service/snackrongbien.png')
INSERT DichVu VALUES ('DV_034',N'CocaCola','','LDV_001','NCC_001',40,50000,'hinh/service/CocaCola.png')
INSERT DichVu VALUES ('DV_035',N'Pepsi','','LDV_001','NCC_001',40,50000,'hinh/service/pepsi.png')

INSERT ChucVu VALUES ('CV_001',N'Nhân Viên Quản Lí','')
INSERT ChucVu VALUES ('CV_002',N'Nhân Viên Bán Hàng','')
INSERT ChucVu VALUES ('CV_003',N'Nhân Viên Phục Vụ','')
INSERT ChucVu VALUES ('CV_004',N'Nhân Viên Tạp Vụ','')

INSERT LoaiPhong VALUES ('LP_001',N'Phòng VIP','')
INSERT LoaiPhong VALUES ('LP_002',N'Phòng Thường','')


INSERT NhanVien VALUES ('NV_001',N'Vũ Tiến Đức',N'TP.HCM','0967664653', 0, 0, 'CV_001')
INSERT NhanVien VALUES ('NV_002',N'Lê Gia Thắng',N'Thanh Hóa','0126865672', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_003',N'Lê Xuân Tuấn Anh',N'Nghệ An','0164538634', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_004',N'Đinh Dương',N'Hà Tĩnh','083453232', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_005',N'Nguyễn Hữu Nam',N'Tiền Giang','076545338', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_006',N'Nguyễn Thị Thanh',N'Bình Phước','0879431264', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_007',N'Lê Thị Tuyết',N'Hậu Giang','068631555', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_008',N'Lê Thanh Phương',N'Bến Trê','032646345', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_009',N'Nguyễn Đức Tài',N'Bạc Liêu','063765316', 0, 0, 'CV_002')
INSERT NhanVien VALUES ('NV_010',N'Lê Huy Phan',N'Hà Nam','0913313564', 0, 0, 'CV_002')

INSERT Phong VALUES ('P_001','VIP 1','LP_001',200000)
INSERT Phong VALUES ('P_002','VIP 2','LP_001',200000)
INSERT Phong VALUES ('P_003','VIP 3','LP_001',200000)
INSERT Phong VALUES ('P_004','VIP 4','LP_001',200000)
INSERT Phong VALUES ('P_005','VIP 5','LP_001',200000)
INSERT Phong VALUES ('P_006','VIP 6','LP_001',200000)
INSERT Phong VALUES ('P_007','VIP 7','LP_001',200000)
INSERT Phong VALUES ('P_008','VIP 8','LP_001',200000)
INSERT Phong VALUES ('P_009','VIP 9','LP_001',200000)
INSERT Phong VALUES ('P_010','Phòng 10','LP_002',100000)
INSERT Phong VALUES ('P_011','Phòng 11','LP_002',100000)
INSERT Phong VALUES ('P_012','Phòng 12','LP_002',100000)
INSERT Phong VALUES ('P_013','Phòng 13','LP_002',100000)
INSERT Phong VALUES ('P_014','Phòng 14','LP_002',100000)
INSERT Phong VALUES ('P_015','Phòng 15','LP_002',100000)
INSERT Phong VALUES ('P_016','Phòng 16','LP_002',100000)
INSERT Phong VALUES ('P_017','Phòng 17','LP_002',100000)
INSERT Phong VALUES ('P_018','Phòng 18','LP_002',100000)
INSERT Phong VALUES ('P_019','Phòng 19','LP_002',100000)
INSERT Phong VALUES ('P_020','Phòng 20','LP_002',100000)
INSERT Phong VALUES ('P_021','Phòng 21','LP_002',100000)
INSERT Phong VALUES ('P_022','Phòng 22','LP_002',100000)
INSERT Phong VALUES ('P_023','Phòng 23','LP_002',100000)
INSERT Phong VALUES ('P_024','Phòng 24','LP_002',100000)
INSERT Phong VALUES ('P_025','Phòng 25','LP_002',100000)
INSERT Phong VALUES ('P_026','Phòng 26','LP_002',100000)
INSERT Phong VALUES ('P_027','Phòng 27','LP_002',100000)
INSERT Phong VALUES ('P_028','Phòng 28','LP_002',100000)
INSERT Phong VALUES ('P_029','Phòng 29','LP_002',100000)
INSERT Phong VALUES ('P_030','Phòng 30','LP_002',100000)
INSERT Phong VALUES ('P_031','Phòng 31','LP_002',100000)
INSERT Phong VALUES ('P_032','Phòng 32','LP_002',100000)

INSERT KhachHang VALUES ('KH_001', N'Vũ Tiến Đức', '0902491471', N'Bình Dương', 0)
INSERT KhachHang VALUES ('KH_002', N'Phùng Ánh Minh', '0585961537', N'Quận 4', 0)
INSERT KhachHang VALUES ('KH_003', N'Lê Xuân Tuấn Anh', '0902491471', N'Quận Thủ Đức', 0)
INSERT KhachHang VALUES ('KH_004', N'Thái Quang Bảo', '0902491471', N'Quận Gò Vấp', 0)
INSERT KhachHang VALUES ('KH_005', N'Peter Jeck', '0902491471', N'NewYork', 0)
INSERT KhachHang VALUES ('KH_006', N'Emma Waston', '0902491471', N'Chicago', 0)


INSERT PhieuNhapHang VALUES ('PNH_001', '16 : 30 ( 29/10/2022 )', 23 ,'5,000,000 VND', 'NCC_001')
INSERT PhieuNhapHang VALUES ('PNH_002', '17 : 30 ( 27/10/2022 )', 24 ,'6,000,000 VND', 'NCC_002')
INSERT PhieuNhapHang VALUES ('PNH_003', '18 : 30 ( 20/10/2022 )', 22 ,'5,000,000 VND', 'NCC_002')
INSERT PhieuNhapHang VALUES ('PNH_004', '19 : 30 ( 21/10/2022 )', 27 ,'5,500,000 VND', 'NCC_004')
INSERT PhieuNhapHang VALUES ('PNH_005', '20 : 30 ( 02/10/2022 )', 24 ,'5,000,000 VND', 'NCC_003')
INSERT PhieuNhapHang VALUES ('PNH_006', '21 : 30 ( 12/10/2022 )', 23 ,'5,400,000 VND', 'NCC_004')
INSERT PhieuNhapHang VALUES ('PNH_007', '22 : 30 ( 25/09/2022 )', 28 ,'5,300,000 VND', 'NCC_004')
INSERT PhieuNhapHang VALUES ('PNH_008', '00 : 30 ( 18/09/2022 )', 29 ,'5,400,000 VND', 'NCC_004')
INSERT PhieuNhapHang VALUES ('PNH_009', '02 : 30 ( 27/09/2022 )', 30 ,'5,400,000 VND', 'NCC_001')
INSERT PhieuNhapHang VALUES ('PNH_010', '09 : 30 ( 27/10/2022 )', 31 ,'5,7000,000 VND', 'NCC_002')
INSERT PhieuNhapHang VALUES ('PNH_011', '10 : 30 ( 25/10/2022 )', 32 ,'6,000,000 VND', 'NCC_004')
INSERT PhieuNhapHang VALUES ('PNH_012', '11 : 30 ( 15/10/2022 )', 23 ,'6,400,000 VND', 'NCC_003')
INSERT PhieuNhapHang VALUES ('PNH_013', '12 : 30 ( 12/10/2022 )', 21 ,'6,500,000 VND', 'NCC_003')
INSERT PhieuNhapHang VALUES ('PNH_014', '13 : 30 ( 14/10/2022 )', 20 ,'8,700,000 VND', 'NCC_005')
INSERT PhieuNhapHang VALUES ('PNH_015', '13 : 30 ( 25/10/2022 )', 20 ,'11,000,000 VND', 'NCC_003')

select * from NhanVien

select * from HoaDon
select * from ChiTietHoaDon



