import {Component, OnInit} from '@angular/core';
import {SequenceFormService} from "../sequence-form.service";

@Component({
    selector: 'app-sequence-form',
    templateUrl: './sequence-form.component.html',
    styleUrls: ['./sequence-form.component.css'],
    providers: [SequenceFormService]
})
export class SequenceFormComponent implements OnInit {

    public resultSequence: string;
    public n: number;

    constructor(private sequenceFormService: SequenceFormService) {
    }

    ngOnInit() {
    }

    onGenerate() {
        this.sequenceFormService.generateSequence(this.n).subscribe(resultSequence => this.resultSequence = resultSequence);
    }
}
