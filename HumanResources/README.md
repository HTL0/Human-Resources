## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Lỗi nhập Tiếng Việt terminal

Em dùng scanner để "nhập Tiếng Việt cho tên nhân viên" hoặc "tìm kiếm nhân viên theo trường name" terminal của IDE không nhận chữ có dấu. Hiển thị của terminal vẫn có đấu bình thường ạ.

Em đã thử trên Mac os thì vẫn nhận nhập Tiếng Việt bình thường (Có ảnh)
Em đã thử đổi charsetName của scanner sang "UTF-16LE" cũng không khả dụng.
Em tìm hiểu và tham khảo qua page này "https://daynhauhoc.com/t/cach-nhap-tieng-viet-tu-console/73006/9", thì thấy terminal được tích hợp của IDE sẽ trả về Null khi nhập kí tự Tiếng Việt có dấu, như terminal trên NetBean không dùng được API System.console.
Em cũng đã thử hỏi mentor và được giải thích vì vấn đề này còn tùy máy và tùy mã hóa ạ.

