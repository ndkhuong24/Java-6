package com.example.demo.bean;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    @NotBlank(message = "Không được để trống email")
    @Email(message = "Không đúng định dạng email")
    private String email;

    @NotBlank(message = "Không được để trống họ và tên")
    private String fullname;

    @NotNull(message = "Không được để trống điểm")
    @PositiveOrZero(message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    private Double marks;

    @NotNull(message = "Chọn giới tính!")
    private Boolean gender;

    @NotBlank(message = "Chọn quốc tịch!")
    private String country;
}
