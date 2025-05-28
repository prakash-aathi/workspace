export class Feedback {

    feedbackId?: number;
    userId: number;
    wifiSchemeId: number;
    category: string;
    feedbackText: string;
    date: Date;

    constructor(userId: number, wifiSchemeId: number, category: string, feedbackText: string, date?: Date, feedbackId?: number) {
        this.userId = userId;
        this.wifiSchemeId = wifiSchemeId;
        this.category = category;
        this.feedbackText = feedbackText;
        this.date = date ? date : new Date();
        if (feedbackId) {
            this.feedbackId = feedbackId;
        }
    }
}