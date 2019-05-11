import * as React from 'react';
import { useFormInput } from '../../shared/form-hook/FormInput';

export interface INewTaskProps {
}

export default function NewTask(props: INewTaskProps) {
  const taskName = useFormInput("");
  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    console.log(taskName.value);
    e.preventDefault();
  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input {...taskName}></input>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
