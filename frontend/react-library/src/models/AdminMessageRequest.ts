class AdminMessageRequest {
    mid: number;
    response: string;

    constructor(mid: number, response: string) {
        this.mid = mid;
        this.response = response;
    }
}

export default AdminMessageRequest;