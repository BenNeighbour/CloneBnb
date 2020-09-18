import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import Button from "@material-ui/core/Button";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogContent from "@material-ui/core/DialogContent";
import { useTheme } from "@material-ui/core/styles";
import useMediaQuery from "@material-ui/core/useMediaQuery";

interface Props extends RouteComponentProps<any> {
  handleClose(): void;
  handleSubmit(rating: number, description: string): void;
  // Pass in the already validated form values
}

const BookModal: React.FC<Props> = (props) => {
  const theme = useTheme();
  const fullScreen = useMediaQuery(theme.breakpoints.down("sm"));

  return (
    <Dialog
      fullScreen={fullScreen}
      open
      onClose={props.handleClose}
      aria-labelledby="responsive-dialog-title"
    >
      <DialogTitle id="responsive-dialog-title">Create review for</DialogTitle>
      <DialogContent
        style={{
          overflow: "hidden",
        }}
      >
        <div
          style={{
            minWidth: "40vw",
            overflow: "hidden",
          }}
        ></div>
      </DialogContent>
      <DialogActions>
        <Button
          autoFocus
          onClick={props.handleClose}
          variant="outlined"
          color="primary"
        >
          Cancel
        </Button>
        <Button type="submit" color="primary" variant="outlined" autoFocus>
          Book Stay
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default BookModal;
