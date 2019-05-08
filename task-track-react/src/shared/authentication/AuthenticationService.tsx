class AuthenticationService {
    isAuthenticated: boolean;
    constructor() {
        this.isAuthenticated = false;
    }

    authenticate(username: string, password: string, callback: (isAuthenticated: boolean) => void) {
        this.isAuthenticated = true;
        callback(this.isAuthenticated);
    }
    signout(callback: (isAuthenticated: boolean) => void) {
        this.isAuthenticated = false;
        callback(this.isAuthenticated);
    }
}

export let Auth = new AuthenticationService();