﻿CREATE DATABASE BAITAP2
USE BAITAP2
SET DATEFORMAT DMY

INSERT INTO HOCVIEN VALUES('K1101','Nguyen Van','An','27/1/1986','Nam','TpHCM','K11')
INSERT INTO HOCVIEN VALUES('K1102','Tran Ngoc','Han','14/3/1986','Nu','Kien Giang','K11')
INSERT INTO HOCVIEN VALUES('K1103','Ha Duy','Lap','18/4/1986','Nam','Nghe An','K11')
INSERT INTO HOCVIEN VALUES('K1104','Tran Ngoc','Linh','30/3/1986','Nu','Tay Ninh','K11')
INSERT INTO HOCVIEN VALUES('K1105','Tran Minh','Long','27/2/1986','Nam','TpHCM','K11')
INSERT INTO HOCVIEN VALUES('K1106','Le Nhat','Minh','24/1/1986','Nam','TpHCM','K11')
INSERT INTO HOCVIEN VALUES('K1107','Nguyen Nhu','Nhut','27/1/1986','Nam','Ha Noi','K11')
INSERT INTO HOCVIEN VALUES('K1108','Nguyen Manh','Tam','27/2/1986','Nam','Kien Giang','K11')
INSERT INTO HOCVIEN VALUES('K1109','Phan Thi Thanh','Tam','27/1/1986','Nu','Vinh Long','K11')
INSERT INTO HOCVIEN VALUES('K1110','Le Hoai','Thuong','5/2/1986','Nu','Can Tho','K11')
INSERT INTO HOCVIEN VALUES('K1111','Le Ha','Vinh','25/12/1986','Nam','Vinh Long','K11')
INSERT INTO HOCVIEN VALUES('K1201','Nguyen Van','Bach','11/2/1986','Nam','TpHCM','K12')
INSERT INTO HOCVIEN VALUES('K1202','Nguyen Thi Kim','Duyen','18/1/1986','Nu','TpHCM','K12')
INSERT INTO HOCVIEN VALUES('K1203','Tran Thi Kim','Duyen','17/9/1986','Nu','TpHCM','K12')
INSERT INTO HOCVIEN VALUES('K1204','Truong My','Hanh','19/5/1986','Nu','Dong Nai','K12')
INSERT INTO HOCVIEN VALUES('K1205','Nguyen Thanh','Nam','17/4/1986','Nam','TpHCM','K12')
INSERT INTO HOCVIEN VALUES('K1206','Nguyen Thi Truc','Thanh','4/3/1986','Nu','Kien Giang','K12')
INSERT INTO HOCVIEN VALUES('K1301','Nguyen Thi Kim','Cuc','9/6/1986','Nu','Kien Giang','K13')
INSERT INTO HOCVIEN VALUES('K1302','Truong Thi My','Hien','18/3/1986','Nu','Nghe An','K13')
INSERT INTO HOCVIEN VALUES('K1303','Le Duc','Hien','21/3/1986','Nam','Tay Ninh','K13')
INSERT INTO HOCVIEN VALUES('K1304','Le Quang','Hien','18/4/1986','Nam','TpHCM','K13')
INSERT INTO HOCVIEN VALUES('K1305','Le Thi','Huong','27/3/1986','Nu','TpHCM','K13')
INSERT INTO HOCVIEN VALUES('K1306','Nguyen Thai','Huu','30/3/1986','Nam','Ha Noi','K13')
INSERT INTO HOCVIEN VALUES('K1307','Tran Minh','Man','28/5/1986','Nam','TpHCM','K13')
INSERT INTO HOCVIEN VALUES('K1308','Nguyen Hieu','Nghia','8/4/1986','Nam','Kien Giang','K13')
INSERT INTO HOCVIEN VALUES('K1309','Nguyen Trung','Nghia','18/1/1987','Nam','Nghe An ','K13')
INSERT INTO HOCVIEN VALUES('K1310','Tran Thi Hong','Tham','22/4/1986','Nu','Tay Ninh','K13')
INSERT INTO HOCVIEN VALUES('K1311','Tran Minh','Thuc','4/4/1986','Nam','TpHCM','K13')
INSERT INTO HOCVIEN VALUES('K1312','Nguyen Thi Kim','Yen','7/9/1986','Nu','TpHCM','K13')
INSERT INTO HOCVIEN VALUES('K1313','Nguyen Thi Truc','Thanh','1/2/1997','Nu','DakLak','K13')

INSERT INTO LOP VALUES('K11','Lop 1 khoa 1','',0,'GV07')
INSERT INTO LOP VALUES('K12','Lop 2 khoa 1','',0,'GV09')
INSERT INTO LOP VALUES('K13','Lop 3 khoa 1','',0,'GV14')
CREATE TABLE LOP(
MALOP CHAR(3) PRIMARY KEY,
TENLOP VARCHAR(50),
TRGLOP VARCHAR(50),
SISO INT,
MAGVCN VARCHAR(50)
)
select * from khoa

create table CacGiaTriDeCapNhapBangHocVien(
dong int, 
maLopHocBanDau varchar(50),
maLopHocDeSua varchar(50)
)
select * from CacGiaTriDeCapNhapBangHocVien
INSERT INTO CacGiaTriDeCapNhapBangHocVien VALUES(0,'','')

CREATE TABLE KHOA(
MAKHOA CHAR(4) PRIMARY KEY,
TENKHOA VARCHAR(50),
NGTLAP date,
TRGKHOA VARCHAR(4),
SOLUONGGIAOVIEN int
)
INSERT INTO KHOA VALUES('KHMT','Khoa hoc may tinh','7/6/2005','GV01',0)
INSERT INTO KHOA VALUES('HTTT','He thong thong tin','7/6/2005','GV02',0)
INSERT INTO KHOA VALUES('CNPM','Cong nghe phan mem','7/6/2005','GV04',0)
INSERT INTO KHOA VALUES('MTT','Mang va truyen thong','20/10/2005','GV03',0)
INSERT INTO KHOA VALUES('KTMT','Ky thuat may tinh','20/12/2005','GV05',0)

INSERT INTO MONHOC VALUES('THDC','Tin hoc dai cuong',4,1,'KHMT')
INSERT INTO MONHOC VALUES('CTRR','Cau truc roi rac',5,2,'KHMT')
INSERT INTO MONHOC VALUES('CSDL','Co so du lieu',3,1,'HTTT')
INSERT INTO MONHOC VALUES('CTDLGT','Cau truc du lieu va giai thuat',3,1,'KHMT')
INSERT INTO MONHOC VALUES('PTTKTT','Phan tich thiet ke thuat toan',3,0,'KHMT')
INSERT INTO MONHOC VALUES('DHMT','Do hoa may tinh',3,1,'KHMT')
INSERT INTO MONHOC VALUES('KTMT','Kien truc may tinh',3,0,'KTMT')
INSERT INTO MONHOC VALUES('TKCSDL','Thiet ke co so du lieu',3,1,'HTTT')
INSERT INTO MONHOC VALUES('PTTKHTTT','Phan tich thiet ke he thong thong tin',4,1,'HTTT')
INSERT INTO MONHOC VALUES('HDH','He dieu hanh',3,0,'KTMT')
INSERT INTO MONHOC VALUES('NMCNPM','Nhap mon cong nghe phan mem',3,0,'CNPM')
INSERT INTO MONHOC VALUES('LTCFW','Lap trinh C for win',3,1,'CNPM')
INSERT INTO MONHOC VALUES('LTHDT','Lap trinh huong doi tuong',3,1,'CNPM')

INSERT INTO DIEUKIEN VALUES ('CSDL','CTRR')
INSERT INTO DIEUKIEN VALUES ('CSDL','CTDLGT')
INSERT INTO DIEUKIEN VALUES ('CTDLGT','THDC')
INSERT INTO DIEUKIEN VALUES ('PTTKTT','THDC')
INSERT INTO DIEUKIEN VALUES ('PTTKTT','CTDLGT')
INSERT INTO DIEUKIEN VALUES ('DHMT','THDC')
INSERT INTO DIEUKIEN VALUES ('LTHDT','THDC')
INSERT INTO DIEUKIEN VALUES ('PTTKHTTT','CSDL')

CREATE TABLE GIAOVIEN(
MAGV CHAR(4) PRIMARY KEY,
HOTEN VARCHAR(50),
HOCVI VARCHAR(50),
GIOITINH VARCHAR(50),
NGSINH date,
LuongCB float,
HESO float,
MUCLUONG MONEY,
MAKHOA VARCHAR(4)
)
INSERT INTO GIAOVIEN VALUES('GV01','Ho Thanh Son','Ths','Nam','2/5/1950',1490000,5,0,'KHMT')
INSERT INTO GIAOVIEN VALUES('GV02','Tran Tam Thanh','TS','Nam','17/12/1965',2190001,4.5,0,'HTTT')
INSERT INTO GIAOVIEN VALUES('GV03','Do Nghiem Phung','TS','Nu','1/8/1950',2310004,4.5,0,'MTT')
INSERT INTO GIAOVIEN VALUES('GV04','Tran Nam Son','TS','Nam','22/2/1961',1380040,4.5,0,'CNPM')
INSERT INTO GIAOVIEN VALUES('GV05','Mai Thanh Danh','Ths','Nam','12/3/1958',2290000,3,0,'KTMT')
INSERT INTO GIAOVIEN VALUES('GV06','Tran Doan Hung','TS','Nam','11/3/1953',3190000,4.5,0,'KHMT')
INSERT INTO GIAOVIEN VALUES('GV07','Nguyen Minh Tien','CN','Nam','23/11/1971',1980000,4,0,'KHMT')
INSERT INTO GIAOVIEN VALUES('GV08','Le Thi Tran','CN','Nu','26/3/1974',2000000,1.69,0,'KHMT')
INSERT INTO GIAOVIEN VALUES('GV09','Nguyen To Lan','ThS','Nu','31/12/1966',2290000,4,0,'HTTT')
INSERT INTO GIAOVIEN VALUES('GV10','Le Tran Anh Loan','CN','Nu','17/7/1972',3310000,1.86,0,'CNPM')
INSERT INTO GIAOVIEN VALUES('GV11','Ho Thanh Tung','CN','Nam','12/1/1980',2250000,2.67,0,'MTT')
INSERT INTO GIAOVIEN VALUES('GV12','Tran Van Anh','CN','Nu','29/3/1981',1234000,1.69,0,'CNPM')
INSERT INTO GIAOVIEN VALUES('GV13','Nguyen Linh Dan','CN','Nu','23/5/1980',4321000,1.69,0,'KTMT')
INSERT INTO GIAOVIEN VALUES('GV14','Truong Minh Chau','Ths','Nu','30/11/1976',3210000,3,0,'MTT')
INSERT INTO GIAOVIEN VALUES('GV15','Le Ha Thanh','ThS','Nam','4/5/1978',2490000,3,0,'KHMT')

select * from KHOA
INSERT INTO GIANGDAY VALUES ('K11','THDC','GV07',1,2006,'2/1/2006','12/5/2006')
INSERT INTO GIANGDAY VALUES ('K12','THDC','GV06',1,2006,'2/1/2006','12/5/2006')
INSERT INTO GIANGDAY VALUES ('K13','THDC','GV15',1,2006,'2/1/2006','12/5/2006')
INSERT INTO GIANGDAY VALUES ('K11','CTRR','GV02',1,2006,'9/1/2006','17/5/2006')
INSERT INTO GIANGDAY VALUES ('K12','CTRR','GV02',1,2006,'9/1/2006','17/5/2006')
INSERT INTO GIANGDAY VALUES ('K13','CTRR','GV08',1,2006,'9/1/2006','17/5/2006')
INSERT INTO GIANGDAY VALUES ('K11','CSDL','GV05',2,2006,'1/6/2006','15/7/2006')
INSERT INTO GIANGDAY VALUES ('K12','CSDL','GV09',2,2006,'1/6/2006','15/7/2006')
INSERT INTO GIANGDAY VALUES ('K13','CTDLGT','GV15',2,2006,'1/6/2006','15/7/2006')
INSERT INTO GIANGDAY VALUES ('K13','CSDL','GV05',3,2006,'1/8/2006','15/12/2006')
INSERT INTO GIANGDAY VALUES ('K13','DHMT','GV07',3,2006,'1/8/2006','15/12/2006')
INSERT INTO GIANGDAY VALUES ('K11','CTDLGT','GV15',3,2006,'1/8/2006','15/12/2006')
INSERT INTO GIANGDAY VALUES ('K12','CTDLGT','GV15',3,2006,'1/8/2006','15/12/2006')
INSERT INTO GIANGDAY VALUES ('K11','HDH','GV04',1,2007,'2/1/2007','18/2/2007')
INSERT INTO GIANGDAY VALUES ('K12','HDH','GV04',1,2007,'2/1/2007','20/3/2007')
INSERT INTO GIANGDAY VALUES ('K11','DHMT','GV07',1,2007,'18/2/2007','20/3/2007')

CREATE TABLE KETQUATHI(
MAHV CHAR(5) ,
MAMH CHAR(8) FOREIGN KEY REFERENCES MONHOC(MAMH),
LANTHI INT,
NGTHI date,
DIEM FLOAT,
KQUA VARCHAR(50),
CONSTRAINT PK_MAHV_MAMH_LANTHI PRIMARY KEY (MAHV,MAMH,LANTHI)
)
select * from KETQUATHI
delete from KETQUATHI 
drop table KETQUATHI
	INSERT INTO KETQUATHI VALUES ('K1101','CSDL',1,'20/7/2006',10,'')
	INSERT INTO KETQUATHI VALUES ('K1101','CTDLGT',1,'28/12/2006',9,'')
	INSERT INTO KETQUATHI VALUES ('K1101','THDC',1,'20/5/2006',9,'')
	INSERT INTO KETQUATHI VALUES ('K1101','CTRR',1,'13/5/2006',9.5,'')
	INSERT INTO KETQUATHI VALUES ('K1102','CSDL',1,'20/7/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1102','CSDL',2,'27/7/2006',4.25,'')
	INSERT INTO KETQUATHI VALUES ('K1102','CSDL',3,'10/8/2006',4.5,'')
	INSERT INTO KETQUATHI VALUES ('K1102','CTDLGT',1,'28/12/2006',4.5,'')
	INSERT INTO KETQUATHI VALUES ('K1102','CTDLGT',2,'5/1/2007',4,'')
	INSERT INTO KETQUATHI VALUES ('K1102','CTDLGT',3,'15/1/2007',6,'')
	INSERT INTO KETQUATHI VALUES ('K1102','THDC',1,'20/5/2006',5,'')
	INSERT INTO KETQUATHI VALUES ('K1102','CTRR',1,'13/5/2006',7,'')
	INSERT INTO KETQUATHI VALUES ('K1103','CSDL',1,'20/7/2006',3.5,'')
	INSERT INTO KETQUATHI VALUES ('K1103','CSDL',2,'27/7/2006',8.25,'')
	INSERT INTO KETQUATHI VALUES ('K1103','CTDLGT',1,'28/12/2006',7,'')
	INSERT INTO KETQUATHI VALUES ('K1103','THDC',1,'20/5/2006',8,'')
	INSERT INTO KETQUATHI VALUES ('K1103','CTRR',1,'13/5/2006',6.5,'')
	INSERT INTO KETQUATHI VALUES ('K1104','CSDL',1,'20/7/2006',3.75,'')
	INSERT INTO KETQUATHI VALUES ('K1104','CTDLGT',1,'28/12/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1104','THDC',1,'20/5/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1104','CTRR',1,'13/5/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1104','CTRR',2,'20/5/2006',3.5,'')
	INSERT INTO KETQUATHI VALUES ('K1104','CTRR',3,'30/6/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1201','CSDL',1,'20/7/2006',6,'')
	INSERT INTO KETQUATHI VALUES ('K1201','CTDLGT',1,'28/12/2006',5,'')
	INSERT INTO KETQUATHI VALUES ('K1201','THDC',1,'20/5/2006',8.5,'')
	INSERT INTO KETQUATHI VALUES ('K1201','CTRR',1,'13/5/2006',9,'')
	INSERT INTO KETQUATHI VALUES ('K1202','CSDL',1,'20/7/2006',8,'')
	INSERT INTO KETQUATHI VALUES ('K1202','CTDLGT',1,'28/12/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1202','CTDLGT',2,'5/1/2007',5,'')
	INSERT INTO KETQUATHI VALUES ('K1202','THDC',1,'20/5/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1202','THDC',2,'27/5/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1202','CTRR',1,'13/5/2006',3,'')
	INSERT INTO KETQUATHI VALUES ('K1202','CTRR',2,'20/5/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1202','CTRR',3,'30/6/2006',6.25,'')
	INSERT INTO KETQUATHI VALUES ('K1203','CSDL',1,'20/7/2006',9.25,'')
	INSERT INTO KETQUATHI VALUES ('K1203','CTDLGT',1,'28/12/2006',9.5,'')
	INSERT INTO KETQUATHI VALUES ('K1203','THDC',1,'20/5/2006',10,'')
	INSERT INTO KETQUATHI VALUES ('K1203','CTRR',1,'13/5/2006',10,'')
	INSERT INTO KETQUATHI VALUES ('K1204','CSDL',1,'20/7/2006',8.5,'')
	INSERT INTO KETQUATHI VALUES ('K1204','CTDLGT',1,'28/12/2006',6.75,'')
	INSERT INTO KETQUATHI VALUES ('K1204','THDC',1,'20/5/2006',4,' ')
	INSERT INTO KETQUATHI VALUES ('K1204','CTRR',1,'13/5/2006',6,'')
	INSERT INTO KETQUATHI VALUES ('K1301','CSDL',1,'20/12/2006',4.25,'')
	INSERT INTO KETQUATHI VALUES ('K1301','CTDLGT',1,'25/7/2006',8,'')
	INSERT INTO KETQUATHI VALUES ('K1301','THDC',1,'20/5/2006',7.75,'')
	INSERT INTO KETQUATHI VALUES ('K1301','CTRR',1,'13/5/2006',8,'')
	INSERT INTO KETQUATHI VALUES ('K1302','CSDL',1,'20/12/2006',6.75,'')
	INSERT INTO KETQUATHI VALUES ('K1302','CTDLGT',1,'25/7/2006',5,'')
	INSERT INTO KETQUATHI VALUES ('K1302','THDC',1,'20/5/2006',8,'')
	INSERT INTO KETQUATHI VALUES ('K1302','CTRR',1,'13/5/2006',8.5,'')
	INSERT INTO KETQUATHI VALUES ('K1303','CSDL',1,'20/12/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1303','CTDLGT',1,'25/7/2006',4.5,'')
	INSERT INTO KETQUATHI VALUES ('K1303','CTDLGT',2,'7/8/2006',4,'')
	INSERT INTO KETQUATHI VALUES ('K1303','CTDLGT',3,'15/8/2006',4.25,'')
	INSERT INTO KETQUATHI VALUES ('K1303','THDC',1,'20/5/2006',4.5,'')
	INSERT INTO KETQUATHI VALUES ('K1303','CTRR',1,'13/5/2006',3.25,'')
	INSERT INTO KETQUATHI VALUES ('K1303','CTRR',2,'20/5/2006',5,'')
	INSERT INTO KETQUATHI VALUES ('K1304','CSDL',1,'20/12/2006',7.75,'')
	INSERT INTO KETQUATHI VALUES ('K1304','CTDLGT',1,'25/7/2006',9.75,'')
	INSERT INTO KETQUATHI VALUES ('K1304','THDC',1,'20/5/2006',5.5,'')
	INSERT INTO KETQUATHI VALUES ('K1304','CTRR',1,'13/5/2006',5,'')
	INSERT INTO KETQUATHI VALUES ('K1305','CSDL',1,'20/12/2006',9.25,'')
	INSERT INTO KETQUATHI VALUES ('K1305','CTDLGT',1,'25/7/2006',10,'')
	INSERT INTO KETQUATHI VALUES ('K1305','THDC',1,'20/5/2006',8,'')
	INSERT INTO KETQUATHI VALUES ('K1305','CTRR',1,'13/5/2006',10,'')

--I.1.TAO QUAN HE VA KHAI BAO CAC RANG BUOC KHOA CHINH, KHOA NGOAI.THEM VAO 3 THUOC TINH GHICHU, DIEMTB, XEPLOAI CHO QUAN HE HOCVIEN
CREATE TABLE HOCVIEN(
MAHV CHAR(5) PRIMARY KEY,
HO VARCHAR(50),
TEN VARCHAR(50),
NGSINH DATETIME,
GIOITINH VARCHAR(5),
NOISINH VARCHAR(50),
MALOP VARCHAR(3)
)

CREATE TABLE MONHOC(
MAMH CHAR(8) PRIMARY KEY,
TENMH VARCHAR(50),
TCLY INT,
TCTH INT,
MAKHOA VARCHAR(50)
)
CREATE TABLE DIEUKIEN(
MAMH CHAR(8),
MAMH_TRUOC CHAR(8),
CONSTRAINT PK_MAMH PRIMARY KEY (MAMH,MAMH_TRUOC)
)

CREATE TABLE GIANGDAY(
MALOP CHAR(3) FOREIGN KEY REFERENCES LOP(MALOP),
MAMH CHAR(8) FOREIGN KEY REFERENCES MONHOC(MAMH),
MAGV CHAR(4) FOREIGN KEY REFERENCES GIAOVIEN(MAGV),
HOCKY INT,
NAM INT,
TUNGAY DATETIME,
DENNGAY DATETIME,
CONSTRAINT PK_MALOP_MAMH PRIMARY KEY (MALOP,MAMH)
)



--THEM THUOC TINH GHICHU,DIEMTB,XEPLOAI
ALTER TABLE HOCVIEN ADD GHICHU VARCHAR(50)
ALTER TABLE HOCVIEN	ADD DIEMTB VARCHAR(50)
ALTER TABLE HOCVIEN ADD XEPLOAI VARCHAR(50)
--THAY DOI KIEU DU LIEU CUA HOCVIEN.LOP
ALTER TABLE HOCVIEN ALTER COLUMN MALOP CHAR(3)
--THEM RANG BUOC KHOA NGOAI CHO MALOP THAM CHIEU DEN LOP.MALOP
ALTER TABLE HOCVIEN	ADD CONSTRAINT FK_MALOP FOREIGN KEY (MALOP) REFERENCES LOP(MALOP)
--I.2.Mã học viên là một chuỗi 5 ký tự, 3 ký tự đầu là mã lớp, 2 ký tự cuối cùng là số thứ tự học viên trong lớp. VD: “K1101”
ALTER TABLE HOCVIEN ADD CONSTRAINT CHECK_MAHV CHECK (LEN(MAHV)=5 AND LEFT(MAHV,3)=MALOP AND RIGHT(MAHV,2) <= 50  )
--I.3.Thuộc tính GIOITINH chỉ có giá trị là “Nam” hoặc “Nu”.
ALTER TABLE HOCVIEN ADD CONSTRAINT CHECK_GIOITINH CHECK(GIOITINH IN ('NAM','NU'))
ALTER TABLE GIAOVIEN ADD CONSTRAINT CHEK_GIOITINH_GIAOVIEN CHECK (GIOITINH IN ('NAM','NU'))
--I.4.Điểm số của một lần thi có giá trị từ 0 đến 10 và cần lưu đến 2 số lẽ (VD: 6.22)
ALTER TABLE KETQUATHI ADD CONSTRAINT CHECK_DIEM CHECK (DIEM BETWEEN 0 AND 10 )
--I.5.Kết quả thi là “Dat” nếu điểm từ 5 đến 10 và “Khong dat” nếu điểm nhỏ hơn 5
ALTER TABLE KETQUATHI ADD CONSTRAINT CHECK_KQUA CHECK ((KQUA='DAT' AND DIEM BETWEEN 5 AND 10) OR (KQUA='KHONG DAT' AND DIEM<5))
--I.6. Học viên thi một môn tối đa 3 lần.
ALTER TABLE KETQUATHI ADD CONSTRAINT CHECK_LANTHI CHECK(LANTHI<=3)
--I.7. Học kỳ chỉ có giá trị từ 1 đến 3.
ALTER TABLE GIANGDAY ADD CONSTRAINT CHECK_HOCKY CHECK (HOCKY BETWEEN 1 AND 3)
--I.8. Học vị của giáo viên chỉ có thể là “CN”, “KS”, “Ths”, ”TS”, ”PTS”.
ALTER TABLE GIAOVIEN ADD CONSTRAINT CHECK_HOCVI CHECK (HOCVI IN ('CN','KS','THS','TS','PTS'))
--I.9.Lớp trưởng của một lớp phải là học viên của lớp đó.
--I.10 Trưởng khoa phải là giáo viên thuộc khoa và có học vị “TS” hoặc “PTS”
--I.11.Học viên ít nhất là 18 tuổi.
ALTER TABLE HOCVIEN ADD CONSTRAINT CHECK_TUOI CHECK (YEAR(GETDATE()) - YEAR(NGSINH) >= 18)
--II.12.Giảng dạy một môn học ngày bắt đầu (TUNGAY) phải nhỏ hơn ngày kết thúc (DENNGAY).
ALTER TABLE GIANGDAY ADD CONSTRAINT CHECK_TUNGAY_DENNGAY CHECK (DENNGAY>TUNGAY)
--I.13.Giáo viên khi vào làm ít nhất là 22 tuổi.
ALTER TABLE GIAOVIEN ADD CONSTRAINT CHECK_TUOI_GV CHECK (YEAR(NGVL)-YEAR(NGSINH)>=22)
--I.14.Tất cả các môn học đều có số tín chỉ lý thuyết và tín chỉ thực hành chênh lệch nhau không quá 3
ALTER TABLE MONHOC ADD CONSTRAINT CHECK_TC CHECK (ABS(TCLY-TCTH)<=3)
--II.1.Tăng hệ số lương thêm 0.2 cho những giáo viên là trưởng khoa.
UPDATE GIAOVIEN
SET MUCLUONG=MUCLUONG*0.2+MUCLUONG
WHERE MAGV IN (SELECT GIAOVIEN.MAGV
FROM GIAOVIEN,KHOA
WHERE GIAOVIEN.MAGV=KHOA.TRGKHOA
)
--II.2.Cập nhật giá trị điểm trung bình tất cả các môn học (DIEMTB) của mỗi học viên (tất cả các môn học đều có hệ số 1 và nếu học viên thi một môn nhiều lần, chỉ lấy điểm của lần thi sau cùng).
UPDATE HOCVIEN
SET DIEMTB = (
SELECT  AVG(DIEM)
FROM KETQUATHI KQT1
WHERE  DIEM IN (SELECT DIEM
FROM KETQUATHI KQT2
WHERE KQT1.MAHV=KQT2.MAHV AND KQT1.MAMH=KQT2.MAMH AND LANTHI IN (SELECT MAX(LANTHI) FROM KETQUATHI KQT3 WHERE KQT3.MAHV=KQT2.MAHV AND KQT2.MAMH=KQT3.MAMH GROUP BY MAHV)
)
GROUP BY MAHV
HAVING MAHV=HOCVIEN.MAHV
)
--II.3.Cập nhật giá trị cho cột GHICHU là “Cam thi” đối với trường hợp: học viên có một môn bất kỳ thi lần thứ 3 dưới 5 điểm
UPDATE HOCVIEN
SET GHICHU='CAM THI'
WHERE MAHV IN (SELECT MAHV
FROM KETQUATHI
WHERE LANTHI='3' AND DIEM<5
)
--II.4.Cập nhật giá trị cho cột XEPLOAI trong quan hệ HOCVIEN như sau:
-- THAY DOI KIEU DU LIEU CHO DIEM
ALTER TABLE HOCVIEN ALTER COLUMN DIEMTB FLOAT(10)
--o Nếu DIEMTB  9 thì XEPLOAI =”XS”
UPDATE HOCVIEN
SET XEPLOAI='XUAT SAC'
WHERE DIEMTB>=9
--o Nếu 8  DIEMTB < 9 thì XEPLOAI = “G”
UPDATE HOCVIEN
SET XEPLOAI='G'
WHERE DIEMTB <9 AND DIEMTB >=8
--o Nếu 6.5  DIEMTB < 8 thì XEPLOAI = “K”
UPDATE HOCVIEN
SET XEPLOAI='K'
WHERE DIEMTB>=6.5 AND DIEMTB<8
--o Nếu 5  DIEMTB < 6.5 thì XEPLOAI = “TB”
UPDATE	HOCVIEN
SET XEPLOAI='TB'
WHERE DIEMTB>=5 AND DIEMTB<6.5
--o Nếu DIEMTB < 5 thì XEPLOAI = ”Y”
UPDATE HOCVIEN
SET XEPLOAI='Y'
WHERE DIEMTB<5
--III.1.In ra danh sach lop truong cac lop 
select *
from lop,HOCVIEN
where hocvien.mahv=lop.TRGLOP
--2.In ra bang diem khi thi mon ctrr cua lop k12, sap xep theo ten, ho hoc vien
select HOCVIEN.MAHV,HO,TEN,LANTHI,DIEM
from HOCVIEN,KETQUATHI,MONHOC
where HOCVIEN.mahv=KETQUATHI.mahv and KETQUATHI.mamh=MONHOC.MAMH and HOCVIEN.MALOP='k12' and monhoc.MAMH='ctrr'
--3.In ra danh sach nhung hoc vien va nhung mon hoc ma hoc vien do thi dau
select HOCVIEN.MAHV,ho,ten,MAMH,KQUA,DIEM
from HOCVIEN,KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and DIEM>=5
--4.In ra danh sach hoc vien cua lop k11 thi mon ctrr khong dat
select *
from HOCVIEN,KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and MAMH='ctrr' and DIEM<=5 and MALOP='k11'
--III.5.In ra danh sach hoc vien cua lop k thi mon crtt khong dat o tat ca cac lan thi
SELECT *
FROM HOCVIEN,KETQUATHI K1
WHERE MAMH='CTRR' AND KQUA='KHONG DAT' AND HOCVIEN.MAHV LIKE 'K%'  AND LANTHI IN (SELECT MAX(LANTHI) FROM KETQUATHI K2 WHERE K1.MAHV=K2.MAHV GROUP BY MAHV) 
AND HOCVIEN.MAHV=K1.MAHV
--III.6.Tim ten nhung mon hoc ma giao vien 'tran tam thanh' day trong hoc ki 1 nam 2006
select HOTEN, TENMH,HOCKY,NAM
from GIAOVIEN,GIANGDAY,MONHOC
where GIAOVIEN.MAGV=GIANGDAY.MAGV and GIANGDAY.MAMH=MONHOC.MAMH and HOTEN='tran tam thanh' and HOCKY='1' and NAM='2006'
--III.7.Tim nhung mon hoc ma giao vien chu nhiem lop k11 day trong hoc ky 1 nam 2006
select HOTEN,MAMH,HOCKY,NAM
from GIAOVIEN,LOP,GIANGDAY
where GIAOVIEN.MAGV=LOP.MAGVCN and GIANGDAY.MAGV=GIAOVIEN.MAGV and GIANGDAY.MALOP='k11' and HOCKY='1' and NAM='2006'
--III.8.Tim ho ten lop truong cua cac lop ma giao vien co ten 'nguyen to lan' day mon 'co so du lieu'
select HO,TEN,TRGLOP,LOP.TENLOP
from GIAOVIEN,GIANGDAY,LOP,HOCVIEN
where GIAOVIEN.MAGV=GIANGDAY.MAGV and GIANGDAY.MALOP=LOP.MALOP and LOP.TRGLOP=HOCVIEN.MAHV and MAMH='csdl' and GIAOVIEN.HOTEN='nguyen to lan'
--9.In ra nhung mon hoc phai lien truoc mon 'co so du lieu'
select *
from MONHOC
where TENMH<'co so du lieu'
--10.Mon 'cau truc roi rac' la mon bat buoc phai lien truoc nhung mon hoc nao
select *
from MONHOC
where 'cau truc roi rac'>TENMH
--11.Tim ho ten giao vien day mon 'cau truc roi rac' cho ca hai lop k11 va k12 trong cung hoc ki 1 nam 2006
select GIAOVIEN.MAGV, GIAOVIEN.HOTEN
from GIAOVIEN,GIANGDAY
where GIAOVIEN.magv=GIANGDAY.MAGV and NAM='2006' and HOCKY='1' and MAMH='ctrr' and MALOP='k11'
intersect
select GIAOVIEN.MAGV, GIAOVIEN.HOTEN
from GIAOVIEN,GIANGDAY
where GIAOVIEN.magv=GIANGDAY.MAGV and NAM='2006' and HOCKY='1' and MAMH='ctrr' and MALOP='k12'
--12.Tim hoc sinh thi khong dat mon CSDL lan 1
select *
from HOCVIEN,KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and MAMH='CSDL' and DIEM<5 and LANTHI='1'
--13.Tim giao vien khong duoc day lop nao
select MAGV,HOTEN
from GIAOVIEN
except
select GIAOVIEN.MAGV,hoten			
from GIAOVIEN,GIANGDAY
where GIAOVIEN.MAGV=GIANGDAY.magv
--14.Tim giao vien khong duoc phan cong giang day bat ky mon hoc nao thuoc khoa giao vien do phu trach
select magv,hoten
from GIAOVIEN
where MAGV not in(select giaovien.MAGV
from GIAOVIEN,GIANGDAY,MONHOC
where GIAOVIEN.MAGV=GIANGDAY.MAGV and GIANGDAY.MAMH=MONHOC.MAMH and GIAOVIEN.MAKHOA=MONHOC.MAKHOA)
--15.Tim ho ten cac hoc vien thuoc lop k11 thi mot mon bat ky qua 3 lan van khong dat hoac thi lan 2 mon ctrr duoc 5 diem
select *
from HOCVIEN
where MALOP='k11' and MAHV in (select MAHV
from KETQUATHI 
where LANTHI='3' and diem<5)
union
select *
from HOCVIEN
where MALOP='k11' and MAHV in (select MAHV
from KETQUATHI
where MAMH='ctrr' and DIEM='5')
--16.Tim ho ten giao vien day mon ctrr cho it nhat 2 lop trong 1 hoc ki cua 1 nam hoc
select *
from GIAOVIEN
where exists (select *
from GIANGDAY a
where GIAOVIEN.MAGV=a.MAGV and MAMH='ctrr'
group by MAGV
having count(distinct malop)>=2 and count (distinct HOCKY)='1' and count (distinct nam)='1'
)
--17.Danh sach hoc vien va diem thi mon csdl sau cung
select hocvien.MAHV,HO,TEN,MAMH,DIEM,LANTHI
from HOCVIEN,KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and MAMH='csdl' and lanthi in(
select max(lanthi)
from KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV
group by MAHV
)
--18.Danh sach hoc vien thi mon CSDL va lay diem cao nhat
select HOCVIEN.MAHV,HO,TEN,max(diem)
from HOCVIEN,KETQUATHI
where MAMH='csdl' and HOCVIEN.MAHV=KETQUATHI.MAHV
group by HOCVIEN.MAHV,HO,TEN
--19.Khoa nao duoc thanh lap som nhat
select top 1 with ties NGTLAP,MAKHOA
from KHOA
order by NGTLAP asc
--20.Co bao nhieu giao vien co hoc ham 'gs' hoac 'PGS'
select HOCHAM, count(magv) soluong
from GIAOVIEN
where HOCHAM='gs' or HOCHAM='pgs'
group by HOCHAM
--21.Thong ke co bao nhieu giao vien co hoc vi la 'cn', 'ks', 'ths', 'ts', 'pts' trong moi khoa
select MAKHOA,HOCVI,count (MAGV)
from GIAOVIEN
group by MAKHOA,HOCVI
order by MAKHOA
--22.Moi mon hoc thong ke so luong hoc vien theo ket qua (dat hoac khong dat)
select mamh,KQUA,count(distinct MAHV) 
from KETQUATHI
group by MAMH,KQUA
order by MAMH
--23.Tim giao vien la giao vien chu nhiem cua mot lop, dong thoi day it nhat cho lop do mot mon hoc
select distinct GIAOVIEN.MAGV,HOTEN
from GIAOVIEN,LOP,GIANGDAY
where GIAOVIEN.MAGV=LOP.MAGVCN and GIAOVIEN.MAGV=GIANGDAY.MAGV and GIANGDAY.MALOP=LOP.MALOP
--24.Tim ho ten lop truong co si so cao nhat
select *
from HOCVIEN 
where exists (select *
from LOP
where HOCVIEN.MAHV=LOP.TRGLOP and SISO in (select top 1 with ties SISO
from LOP
order by SISO desc
)
)
--25.Tim ho ten lop truong thi khong dat qua 3 mon(moi mon deu thi khong dat o tat ca cac lan thi)
select *
from HOCVIEN,LOP,KETQUATHI
where HOCVIEN.MAHV=lop.TRGLOP and LOP.TRGLOP=KETQUATHI.MAHV AND KQUA='KHONG DAT' AND LANTHI IN(SELECT MAX(LANTHI) FROM KETQUATHI WHERE LOP.TRGLOP=KETQUATHI.MAHV GROUP BY MAHV)
--26.Tim hoc vien co so mon dat diem 9,10 nhieu nhat
select HOCVIEN.MAHV,count(diem)
from HOCVIEN,KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and DIEM='10' or diem='9'
group by HOCVIEN.MAHV
order by HOCVIEN.MAHV
--27.Trong tung lop,tim hoc vien co mon dat diem 9,10 nhieu nhat
select  MALOP,HOCVIEN.MAHV, count(diem)
from HOCVIEN,KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and DIEM>=9
group by MALOP,HOCVIEN.MAHV
--28.Trong tung hoc ky cua tung nam,moi giao vien phan cong day bao nhieu mon hoc,bao nhieu lop
select GIAOVIEN.MAGV,HOTEN,count(distinct mamh) 'mon hoc', count(distinct MALOP) solop,HOCKY,NAM
from GIAOVIEN,GIANGDAY
where GIAOVIEN.MAGV=GIANGDAY.MAGV
group by NAM,HOCKY,GIAOVIEN.MAGV,HOTEN
--29.Trong hoc ky tung nam,moi giao vien giang day nhieu nhat
select RANK() OVER(ORDER BY SUM(DATEDIFF(DAY,TUNGAY, DENNGAY)) DESC) BXH, NAM,HOCKY,GIAOVIEN.MAGV, SUM(DATEDIFF(DAY, TUNGAY,DENNGAY)) TGDAY
from GIAOVIEN,GIANGDAY GD1
where GIAOVIEN.MAGV=GD1.MAGV
group by NAM,HOCKY, GIAOVIEN.MAGV	
HAVING	SUM(DATEDIFF(DAY,TUNGAY, DENNGAY)) >=ALL(SELECT SUM(DATEDIFF(DAY,TUNGAY, DENNGAY))
FROM GIANGDAY GD2
WHERE GD1.NAM=GD2.NAM AND GD1.HOCKY=GD2.HOCKY
GROUP BY NAM,HOCKY, MAGV
)
--30.Tim mon hoc co hoc vien thi khong dat nhieu nhat
select top 1 with ties count(distinct MAHV) 'so hoc vien thi khong dat',MAMH
from KETQUATHI
where KQUA='khong dat'
group by MAMH
order by count(distinct mahv) desc
--31.Tim hoc vien thi mon nao cung dat (xet lan 1)
select *
from HOCVIEN,KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and  not exists (select *
from KETQUATHI
where HOCVIEN.MAHV=KETQUATHI.MAHV and LANTHI='1' and KQUA='khong dat'
)
--III.32.Tim hoc vien thi mon nao cung dat (xet lan thi sau cung)
SELECT DISTINCT HOCVIEN.MAHV
FROM HOCVIEN,KETQUATHI
WHERE HOCVIEN.MAHV=KETQUATHI.MAHV AND HOCVIEN.MAHV NOT IN(
SELECT HOCVIEN.MAHV
FROM HOCVIEN,KETQUATHI K0
WHERE HOCVIEN.MAHV=K0.MAHV AND KQUA='KHONG DAT' AND LANTHI IN (SELECT MAX(LANTHI) FROM KETQUATHI K1 WHERE K0.MAHV=K1.MAHV  GROUP BY MAHV)
)
--III.33.Tim hoc vien da thi tat ca cac mon deu dat (chi xet lan thi 1)
SELECT *
FROM HOCVIEN,KETQUATHI
WHERE NOT EXISTS (SELECT *
FROM MONHOC
WHERE NOT EXISTS (SELECT *
FROM KETQUATHI
WHERE HOCVIEN.MAHV=KETQUATHI.MAHV AND KETQUATHI.MAMH=MONHOC.MAMH AND LANTHI='1' AND KQUA='DAT'
)
)
--III.34.TIM HOC VIEN DA THI TAT CA CAC MON DEU DAT (CHI XET LAN SAU CUNG)
SELECT *
FROM HOCVIEN
WHERE NOT EXISTS (SELECT *
FROM MONHOC
WHERE NOT EXISTS (SELECT *
FROM KETQUATHI K0
WHERE K0.MAMH=MONHOC.MAMH AND K0.MAHV=HOCVIEN.MAHV AND KQUA='DAT' AND LANTHI IN(SELECT MAX(LANTHI) FROM KETQUATHI K1 WHERE K1.MAHV=K0.MAHV GROUP BY MAHV)
)
)
--III.35.TIM HOC VIEN CO DIEM THI CAO NHAT TRONG TUNG MON (LAY DIEM THI O LAN THI SAU CUNG)
SELECT *
FROM HOCVIEN,KETQUATHI
WHERE HOCVIEN.MAHV=KETQUATHI.MAHV AND DIEM IN (SELECT MAX(DIEM)
FROM KETQUATHI
WHERE DIEM IN (SELECT  MAX(DIEM)
FROM HOCVIEN,KETQUATHI
WHERE HOCVIEN.MAHV=KETQUATHI.MAHV
GROUP BY MAMH
)
)

