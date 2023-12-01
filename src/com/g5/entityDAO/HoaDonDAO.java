/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;

import com.g5.entity.HoaDon;
import com.g5.entity.NhanVien;
import com.g5.util.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.g5.DAO.HoaDonDAOinterface;

/**
 *
 * @author Asus
 */
public class HoaDonDAO implements HoaDonDAOinterface {

    String selectByID = "select * from HoaDon where maHD = ?";
    String selectAll = "select * from HoaDon";
    String insert = "insert into HoaDon (NgayTao,MaNV,TienKhach,GhiChu,TrangThai) "
            + "values (?,?,?,?,?)";
    String update = "Update HoaDon set NgayTao=?,MaNV=?, TienKhach=?, GhiChu=?, TrangThai=? where MaHD =?";
    String delete = "Delete from HoaDon where MaHD = ?";
    String last = "SELECT * FROM HoaDon ORDER BY MaHD DESC";

    @Override
    public HoaDon getByID(Integer id) {
        List<HoaDon> list = select(selectByID, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public String getLast() {
        List<HoaDon> list = select(last);
        return list.size() > 0 ? String.valueOf(list.get(0).getMaHD() + 1).trim() : "Lỗi truy vấn";
    }
     public List<HoaDon> select() {//
        String sql = "SELECT * FROM HoaDon";
        return select(sql);
    }

    @Override
    public List<HoaDon> getAll() {
        return select(selectAll);
    }

    @Override
    public Integer create(HoaDon hd) {
        try {
            JDBCHelper.executeUpdate(insert,
                    hd.getNgayTao(),
                    hd.getMaNV(),
                    hd.getTienKhachTra(),
                    hd.getGhiChu(),
                    hd.isTrangthai()
            );

            return hd.getMaHD();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(HoaDon hd) {
        JDBCHelper.executeUpdate(update,
                hd.getNgayTao(),
                hd.getMaNV(),
                hd.getTienKhachTra(),
                hd.getGhiChu(),
                hd.isTrangthai(),
                hd.getMaHD());
    }

    @Override
    public void deteleByID(Integer id) {
        JDBCHelper.executeUpdate(delete, id);
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
              //  rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHD(rs.getInt("MaHD"));
        model.setNgayTao(rs.getDate("NgayTao"));
        model.setMaNV(rs.getInt("MaNV"));
        model.setTienKhachTra(rs.getFloat("TienKhach"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setTrangthai(rs.getBoolean("TrangThai"));
        return model;
    }

}
