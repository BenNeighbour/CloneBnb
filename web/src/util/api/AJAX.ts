import axios from "axios";
import * as Constants from "../Constants";

function getCsrfTokenFromCookies(cookies: string): string {
  return `${cookies
    .split("; ")
    .find((row) => row.startsWith("XSRF-TOKEN"))}`.split("=")[1];
}

const extraRequestHeaders = {
  withCredentials: true,
  headers: { "X-XSRF-TOKEN": getCsrfTokenFromCookies(document.cookie) },
};

export async function USER_LOGIN(formObject: any): Promise<any> {
  let res = await axios.post(
    `${Constants.SERVER_BASE_ROUTE}/auth/`,
    formObject,
    extraRequestHeaders
  );

  await axios
    .get(`${Constants.SERVER_BASE_ROUTE}/auth/me/`, extraRequestHeaders)
    .then((response: any) => {
      localStorage.setItem("uid", response.data.id);
    });
  
  return res;
}

export function LISTING_SEARCH(params: Array<string>): any {
  return axios.get(
    `${Constants.SERVER_BASE_ROUTE}/listing/search?query=${params[0]}&${params[1]}&${params[2]}`,
    extraRequestHeaders
  );
}

export function LISTING_PAGE(listingId: string): any {
  return axios.get(
    `${Constants.SERVER_BASE_ROUTE}/listing/by/${listingId}`,
    extraRequestHeaders
  );
}

export function REVIEWER_PAGE(): any {
  return axios.get(
    `${Constants.SERVER_BASE_ROUTE}/listing/review/unreviewed/${localStorage.getItem("uid")}/`,
    extraRequestHeaders
  );
}
