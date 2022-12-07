package uz.jl.blogpost.creationaldp.builder;


import javax.print.DocFlavor;

public class Employee {
    private String id;
    private String username;
    private String password;
    private String status;
    private String role;

    public Employee(String id, String username, String password, String status, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String username;
        private String password;
        private String status;
        private String role;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Employee build() {
            return new Employee(this.id, this.username, this.password, this.status, this.role);
        }

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
