package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

import java.util.UUID;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_lieu")
public class ChatLieu {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, length = 30)
    private String ma;

    @Column(name = "loai_chat_lieu")
    private String loaiChatLieu;

    @Column(name = "ngay_tao", columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @Column(name = "mo_ta")
    private String moTa;
}