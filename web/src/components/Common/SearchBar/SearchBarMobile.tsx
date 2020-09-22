import { Card } from "@material-ui/core";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import TextField from "@material-ui/core/TextField";
import { Formik, Form } from "formik";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";

interface Props extends RouteComponentProps<any> {}

const SearchBarMobile: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        textAlign: "center",
        display: "inline-block",
      }}
    >
      <Card
        style={{
          minHeight: "7vh",
          width: "100vw",
          borderRadius: 0,
        }}
      >
        <Grid container>
          <Formik
            onSubmit={(formValues) => {
              let checkInDate: string = "";
              let checkOutDate: string = "";

              // Redirect to search route
              props.history.push(
                `/search?location=${formValues.location}&checkIn=${checkInDate}&checkOut=${checkOutDate}`
              );
            }}
            initialValues={{
              location: "",
              checkInDate: new Date(),
              checkOutDate: new Date(),
            }}
          >
            {({ values, handleChange }) => (
              <Form
                style={{
                  display: "contents",
                }}
              >
                <Grid xs={9} item>
                  <div
                    style={{
                      paddingTop: "0.5vh",
                      paddingBottom: "0.5vh",
                      flex: "1 0 0",
                      paddingRight: "1vw",
                      paddingLeft: "2vw",
                    }}
                  >
                    <TextField
                      value={values.location}
                      onChange={handleChange}
                      fullWidth
                      focused
                      label="Location"
                      name="location"
                    />
                  </div>
                </Grid>
                <Grid
                  xs={3}
                  item
                  style={{
                    placeItems: "center",
                    verticalAlign: "center",
                  }}
                >
                  <Button
                    style={{
                      borderRadius: "35px",
                      width: "min-content",
                      padding: "6px",
                      marginLeft: "auto",
                      boxShadow: "none",
                      textTransform: "none",
                    }}
                    type="submit"
                    color="primary"
                    variant="contained"
                    className="profile-button"
                    fullWidth
                  >
                    Next
                  </Button>
                </Grid>
              </Form>
            )}
          </Formik>
        </Grid>
      </Card>
    </div>
  );
};

export default SearchBarMobile;
