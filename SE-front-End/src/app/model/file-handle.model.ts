import { SafeUrl } from "@angular/platform-browser";

export interface FileHandle {
    push(fileHandle: FileHandle): unknown;

    file: File,
    url: SafeUrl
}