export interface WifiSchemeRequest {

    wifiSchemaRequestId?: number;
    userId: number;
    wifiSchemeId: number;
    requestDate: Date;
    status: string;
    comments?: string;
    proof?: string; // base64 encoded string
    streetName?: string;
    landmark?: string;
    city?: string;
    zipCode?: string;
    prefferedSetupDate?: Date;
    timeSlot?: string;
 }