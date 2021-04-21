package com.javassem.domain;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int b_id;
	private String b_name;
	private String b_email;
	private String b_title;
	private String b_content;
	private String b_pwd;
	private String b_date;
	private int b_count;
	private String b_ip;
	private String b_fname;
	private long b_fsize;

	// *************************************************
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file, HttpServletRequest request) {
		this.file = file;
		if (!file.isEmpty()) {
			// 절대경로
			b_fname = file.getOriginalFilename();
			b_fsize = file.getSize();
			File f = new File("\\src\\main\\webapp\\resources\\upload\\" + b_fname); // 경로는 webapp 밑 resource 안에 구성

			// 상대경로
//			String root_path = request.getSession().getServletContext().getRealPath("/");
//			System.out.println(root_path);
//			String attach_path = "resources/upload/";
//			String filename = file.getOriginalFilename();
//			File f = new File(root_path + attach_path + filename);

			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_email() {
		return b_email;
	}

	public void setB_email(String b_email) {
		this.b_email = b_email;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_pwd() {
		return b_pwd;
	}

	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public int getB_count() {
		return b_count;
	}

	public void setB_count(int b_count) {
		this.b_count = b_count;
	}

	public String getB_ip() {
		return b_ip;
	}

	public void setB_ip(String b_ip) {
		this.b_ip = b_ip;
	}

	public String getB_fname() {
		return b_fname;
	}

	public void setB_fname(String b_fname) {
		this.b_fname = b_fname;
	}

	public long getB_fsize() {
		return b_fsize;
	}

	public void setB_fsize(long b_fsize) {
		this.b_fsize = b_fsize;
	}

}
