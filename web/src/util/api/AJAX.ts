import axios from "axios";
import * as Constants from "../Constants";

function getCsrfTokenFromCookies(cookies: string): string {
  return `${cookies
    .split("; ")
    .find((row) => row.startsWith("XSRF-TOKEN"))}`.split("=")[1];
}


const extraRequestHeaders = {
    withCredentials: true,
    headers: {"X-XSRF-TOKEN": getCsrfTokenFromCookies(document.cookie)}
};

export function USER_LOGIN(formObject: any): any {
  return axios.post(
    `${Constants.SERVER_BASE_ROUTE}/auth/`,
      formObject,
    extraRequestHeaders
  );
}
