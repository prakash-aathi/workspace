export class User {
    userId?: number;
    email: string;
    password: string;
    username: string;
    mobileNumber: string;
    userRole: string;

    constructor(email: string, password: string, username: string, mobileNumber: string, userRole: string, userId?: number) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;
        if (userId) {
            this.userId = userId;
        }
    }
}